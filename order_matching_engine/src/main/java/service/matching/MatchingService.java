package service.matching;

import inmemory.InMemoryTrade;
import inmemory.OrderBook;
import model.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

/*
 MatchingService is responsible for:
  - Matching BUY and SELL orders
  - Maintaining price-time priority (FIFO)
  - Executing trades
  - Handling concurrency safely
 */
public class MatchingService implements Matching {

    // Holds BUY and SELL order queues per trade type
    private final OrderBook orderBook;

    // Stores executed trades in memory
    private final InMemoryTrade tradeBook;

    /*
      One lock per TradeType (EQUITY, FOREX, CRYPTO)
      This allows parallel processing for different trade types

     */
    private final Map<TradeType, Object> locks = new ConcurrentHashMap<>();

    public MatchingService(OrderBook orderBook, InMemoryTrade tradeBook) {
        this.orderBook = orderBook;
        this.tradeBook = tradeBook;

        // Initialize a dedicated lock object for each TradeType
        for (TradeType type : TradeType.values()) {
            locks.put(type, new Object());
        }
    }

    /**
     * Matches an incoming order against existing opposite orders
     */
    @Override
    public void match(Order incoming) {

        // Synchronize only on the lock for this trade type
        // Prevents race conditions while allowing parallelism
        synchronized (locks.get(incoming.getTradeType())) {

            // Ignore invalid or already filled orders
            if (incoming.getRemainingQuantity() <= 0) return;

            /**
             * Determine opposite order queue:
             * BUY order → match with SELL queue
             * SELL order → match with BUY queue
             */
            PriorityBlockingQueue<Order> oppositeQueue =
                    incoming.getOrderType() == OrderType.BUY
                            ? orderBook.getSellQueue(incoming.getTradeType())
                            : orderBook.getBuyQueue(incoming.getTradeType());

            // Continue matching until order is filled or no suitable orders exist
            while (incoming.getRemainingQuantity() > 0 && !oppositeQueue.isEmpty()) {

                // Fetch best-priced opposite order (price-time priority)
                Order topOpp = oppositeQueue.poll();

                /**
                 * Price validation:
                 * BUY → incoming price must be >= sell price
                 * SELL → incoming price must be <= buy price
                 *
                 * 100 <= 105  ok
                 *
                 * 110 <= 105 not ok
                 */
                boolean priceMatch = incoming.getOrderType() == OrderType.BUY
                        ? incoming.getPrice() >= topOpp.getPrice()
                        : incoming.getPrice() <= topOpp.getPrice();

                // If prices do not match, stop further matching
                if (!priceMatch) {
                    oppositeQueue.add(topOpp);
                    break;
                }

                /**
                 * Calculate matched quantity
                 * (supports partial matching)
                 */
                long matchQty = Math.min(
                        incoming.getRemainingQuantity(),
                        topOpp.getRemainingQuantity()
                );

                /**
                 * Execution price logic:
                 * Older order gets price priority
                 *
                 * Example 1
                 *
                 * Someone put SELL at ₹100 at 10:00
                 *
                 * You put BUY at ₹105 at 10:05
                 *
                 * ➡ Trade happens at ₹100
                 * ➡ Because SELL order came first
                 */
                double execPrice = topOpp.getTimestamp().before(incoming.getTimestamp())
                        ? topOpp.getPrice()
                        : incoming.getPrice();

                /**
                 * Create trade record
                 */
                Trade trade = new Trade(
                        tradeBook.generateTradeId(),
                        incoming.getOrderType() == OrderType.BUY
                                ? incoming.getOrderId()
                                : topOpp.getOrderId(),
                        incoming.getOrderType() == OrderType.BUY
                                ? topOpp.getOrderId()
                                : incoming.getOrderId(),
                        execPrice,
                        matchQty,
                        Timestamp.from(Instant.now()),
                        incoming.getTradeType()
                );

                // Persist executed trade
                tradeBook.saveTrade(trade);

                // Update remaining quantities
                incoming.setRemainingQuantity(incoming.getRemainingQuantity() - matchQty);
                topOpp.setRemainingQuantity(topOpp.getRemainingQuantity() - matchQty);

                // Update order statuses
                updateStatus(incoming);
                updateStatus(topOpp);

                // Reinsert partially filled opposite order back into queue
                if (topOpp.getRemainingQuantity() > 0) {
                    oppositeQueue.add(topOpp);
                }
            }

            // Final status update for incoming order
            updateStatus(incoming);

            // If incoming order is not fully filled, add it to order book
            if (incoming.getRemainingQuantity() > 0) {
                orderBook.addOrder(incoming);
            }
        }
    }

    /**
     * Updates order status based on remaining quantity
     */
    private void updateStatus(Order order) {
        if (order.getRemainingQuantity() <= 0) {
            order.setStatus(OrderStatus.FILLED);
        } else if (order.getRemainingQuantity() < order.getQuantity()) {
            order.setStatus(OrderStatus.PARTIALLY_FILLED);
        } else {
            order.setStatus(OrderStatus.PENDING);
        }
    }
}



/*
Matches orders correctly

Maintains price-time priority (FIFO)

Handles concurrent orders safely

Executes trades and stores them
 */