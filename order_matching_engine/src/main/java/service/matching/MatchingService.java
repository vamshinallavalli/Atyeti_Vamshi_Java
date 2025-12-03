package service.matching;

import inmemory.InMemoryOrderBook;
import inmemory.InMemoryTrade;
import model.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.concurrent.PriorityBlockingQueue;

public class MatchingService {

    private final InMemoryOrderBook orderBook;
    private final InMemoryTrade tradeBook;

    public MatchingService(InMemoryOrderBook orderBook, InMemoryTrade tradeBook) {
        this.orderBook = orderBook;
        this.tradeBook = tradeBook;
    }

    public void match(Order incoming) {
        if (incoming.getRemainingQuantity() <= 0) return;

        PriorityBlockingQueue<Order> oppQueue = incoming.getOrderType() == OrderType.BUY
                ? orderBook.getSellQueue(incoming.getTradeType())
                : orderBook.getBuyQueue(incoming.getTradeType());

        while (incoming.getRemainingQuantity() > 0 && !oppQueue.isEmpty()) {
            Order topOpp = oppQueue.poll();

            boolean priceMatch = incoming.getOrderType() == OrderType.BUY
                    ? incoming.getPrice() >= topOpp.getPrice()
                    : incoming.getPrice() <= topOpp.getPrice();

            if (!priceMatch) {
                oppQueue.add(topOpp);  // put back
                break;
            }

            long matchQty = Math.min(incoming.getRemainingQuantity(), topOpp.getRemainingQuantity());

            double execPrice = topOpp.getTimestamp().before(incoming.getTimestamp())
                    ? topOpp.getPrice()
                    : incoming.getPrice();

            Trade trade = new Trade(
                    tradeBook.generateTradeId(),
                    incoming.getOrderType() == OrderType.BUY ? incoming.getOrderId() : topOpp.getOrderId(),
                    incoming.getOrderType() == OrderType.BUY ? topOpp.getOrderId() : incoming.getOrderId(),
                    execPrice,
                    matchQty,
                    Timestamp.from(Instant.now()),
                    incoming.getTradeType()
            );

            tradeBook.saveTrade(trade);

            incoming.setRemainingQuantity(incoming.getRemainingQuantity() - matchQty);
            topOpp.setRemainingQuantity(topOpp.getRemainingQuantity() - matchQty);

            // Update status after every match
            updateOrderStatus(incoming);
            updateOrderStatus(topOpp);

            // Only re-add if still has quantity
            if (topOpp.getRemainingQuantity() > 0) {
                oppQueue.add(topOpp);
            }
            // else: fully filled → leave it out
        }

        updateOrderStatus(incoming);

        if (incoming.getRemainingQuantity() > 0) {
            orderBook.addOrder(incoming);
        }
    }

    private void updateOrderStatus(Order order) {
        if (order.getRemainingQuantity() <= 0) {
            order.setStatus(OrderStatus.FILLED);
        } else if (order.getRemainingQuantity() < order.getQuantity()) {
            order.setStatus(OrderStatus.PARTIALLY_FILLED);
        } else {
            order.setStatus(OrderStatus.PENDING);
        }
    }
}



//package service.matching;
//
//import inmemory.InMemoryOrderBook;
//import inmemory.InMemoryTrade;
//import model.Order;
//import model.OrderType;
//import model.Trade;
//
//import java.sql.Timestamp;
//import java.time.Instant;
//import java.time.LocalDateTime;
//
///**
// * Simple matching service implementing price-time priority with partial fills.
// */
//public class MatchingService {
//
//    private final InMemoryOrderBook orderBook;
//    private final InMemoryTrade tradeBook;
//
//    public MatchingService(InMemoryOrderBook orderBook, InMemoryTrade tradeBook) {
//        this.orderBook = orderBook;
//        this.tradeBook = tradeBook;
//    }
//
//    public void match(Order incoming) {
//
//        var book = orderBook.getBook(incoming.getTradeType());
//
//        // BUY order → match against SELL queue
//        // SELL order → match against BUY queue
//        var oppQueue = (incoming.getOrderType() == OrderType.BUY)
//                ? book.getSellQueue()
//                : book.getBuyQueue();
//
//        while (incoming.getQuantity() > 0 && !oppQueue.isEmpty()) {
//
//            Order topOpp = oppQueue.peek();
//            if (topOpp == null) break;
//
//            // --- Price Condition ---
//            boolean priceMatch;
//
//            if (incoming.getOrderType() == OrderType.BUY) {
//                priceMatch = incoming.getPrice() >= topOpp.getPrice();
//            } else {
//                priceMatch = incoming.getPrice() <= topOpp.getPrice();
//            }
//
//            if (!priceMatch) break;
//
//            // Remove opposite order from queue (we're matching it)
//            topOpp = oppQueue.poll();
//
//            long matchQty = Math.min(
//                    incoming.getQuantity(),
//                    topOpp.getQuantity()
//            );
//
//            double executionPrice =
//                    topOpp.getTimestamp().before(incoming.getTimestamp())
//                            ? topOpp.getPrice()
//                            : incoming.getPrice();
//
//            // --- Create trade ---
//            Trade trade = new Trade(
//                    "T" + System.nanoTime(),
//                    incoming.getOrderId(),
//                    topOpp.getOrderId(),
//                    executionPrice,
//                    matchQty,
//                    new Timestamp(System.currentTimeMillis()),
//                    incoming.getTradeType()
//            );
//
//            tradeBook.saveTrade(trade);
//
//            // Update remaining quantities
//            incoming.setQuantity(incoming.getQuantity() - matchQty);
//            topOpp.setQuantity(topOpp.getQuantity() - matchQty);
//
//            // If opposite still has quantity → put back
//            if (topOpp.getQuantity() > 0) {
//                oppQueue.add(topOpp);
//            }
//
//            // If incoming done → stop
//            if (incoming.getQuantity() <= 0) break;
//        }
//    }
//}
