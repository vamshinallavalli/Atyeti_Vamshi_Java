package inmemory;

import model.Order;
import model.OrderType;
import model.TradeType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class InMemoryOrderBook {

    private final Map<TradeType, OrderBookSide> books = new ConcurrentHashMap<>();

    // Keep ALL orders ever submitted — for final reporting
    private final List<Order> allSubmittedOrders = new CopyOnWriteArrayList<>();

    public static class OrderBookSide {
        // Thread-safe, lock-free priority queues
        public final PriorityBlockingQueue<Order> buyQueue = new PriorityBlockingQueue<>(100,
                Comparator.comparingDouble(Order::getPrice).reversed()
                        .thenComparing(Order::getTimestamp));

        public final PriorityBlockingQueue<Order> sellQueue = new PriorityBlockingQueue<>(100,
                Comparator.comparingDouble(Order::getPrice)
                        .thenComparing(Order::getTimestamp));
    }

    public OrderBookSide getBookSide(TradeType tradeType) {
        return books.computeIfAbsent(tradeType, k -> new OrderBookSide());
    }

    public PriorityBlockingQueue<Order> getBuyQueue(TradeType tt) {
        return getBookSide(tt).buyQueue;
    }

    public PriorityBlockingQueue<Order> getSellQueue(TradeType tt) {
        return getBookSide(tt).sellQueue;
    }

    public void addOrder(Order order) {
        allSubmittedOrders.add(order);  // Keep for reporting

        if (order.getOrderType() == OrderType.BUY) {
            getBuyQueue(order.getTradeType()).add(order);
        } else {
            getSellQueue(order.getTradeType()).add(order);
        }
    }

    public List<Order> getAllOrders() {
        return Collections.unmodifiableList(new ArrayList<>(allSubmittedOrders));
    }
}


//package inmemory;
//
//import model.Order;
//import model.OrderType;
//import model.TradeType;
//
//import java.util.Collections;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class InMemoryOrderBook {
//
//    Map<TradeType, OrderBook> books=new ConcurrentHashMap<>();
//    Map<String,Order> orders=new ConcurrentHashMap<>();
//
//    public void saveOrder(Order order) {
//
//        orders.put(order.getOrderId(),order);
//
//        OrderBook book=books.get(order.getTradeType());
//
//        if(order.getOrderType()== OrderType.BUY){
//            book.getBuyQueue().add(order);
//        }else{
//            book.getSellQueue().add(order);
//        }
//    }
//
//    public Object getAllOrders() {
//        return Collections.unmodifiableCollection(orders.values());
//    }
//
//    public OrderBook getBook(TradeType type) {
//        return books.get(type);
//    }
//
//}
