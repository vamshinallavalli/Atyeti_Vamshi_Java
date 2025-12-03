package service;

import org.slf4j.Logger;
import inmemory.InMemoryOrderBook;
import inmemory.InMemoryTrade;
import model.*;
import org.slf4j.LoggerFactory;
import service.matching.MatchingService;
import service.validator.OrderValidationEngine;

import java.sql.Timestamp;
import java.util.concurrent.ConcurrentHashMap;

public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);


    private final InMemoryOrderBook orderBook;
    private final InMemoryTrade tradeBook;
    private final MatchingService matchingService;
    private final OrderValidationEngine validator;

    private int totalOrdersLoaded = 0;
    private int rejectedOrders = 0;
    private int validOrders = 0;

    // For duplicate order ID protection (optional but recommended)
    private final java.util.Set<String> seenOrderIds = ConcurrentHashMap.newKeySet();

    public OrderService() {
        this.orderBook = new InMemoryOrderBook();
        this.tradeBook = new InMemoryTrade();
        this.matchingService = new MatchingService(orderBook, tradeBook);
        this.validator = new OrderValidationEngine();
    }

    // Main public API
    public synchronized Order submitOrder(String orderId, String traderId, TradeType tradeType,
                                          OrderType orderType, double price, long quantity,
                                          String country, Timestamp timestamp) {
        totalOrdersLoaded++;

        // Prevent duplicate order IDs
        if (!seenOrderIds.add(orderId)) {
            rejectedOrders++;
            System.err.println("DUPLICATE ORDER ID REJECTED: " + orderId);
            Order rejected = new Order();
            rejected.setStatus(OrderStatus.REJECTED);
            return rejected;
        }

        Order order = new Order(orderId, traderId, tradeType, orderType, price, quantity, country, timestamp);

        try {
            validator.validate(order);
            validOrders++;
            matchingService.match(order);
            return order;
        } catch (Exception e) {
            rejectedOrders++;
            order.setStatus(OrderStatus.REJECTED);
            log.warn("REJECTED {}: {}", orderId, e.getMessage());
            log.warn("DUPLICATE ORDER ID REJECTED: {}", orderId);
            return order;
        }
    }

    // This is the method CsvReader uses
    public Order submitCsvOrder(String orderId, String traderId, TradeType tradeType,
                                OrderType orderType, double price, long quantity,
                                String country, Timestamp timestamp) {
        return submitOrder(orderId, traderId, tradeType, orderType, price, quantity, country, timestamp);
    }

    // Getters
    public int getTotalOrdersLoaded() { return totalOrdersLoaded; }
    public int getRejectedOrders()   { return rejectedOrders; }
    public int getValidOrders()      { return validOrders; }
    public InMemoryOrderBook getOrderBook() { return orderBook; }
    public InMemoryTrade getTradeRepository() { return tradeBook; }
}

//package service;
//
//import inmemory.InMemoryOrderBook;
//import inmemory.InMemoryTrade;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import model.Order;
//import model.OrderType;
//import model.TradeType;
//import service.matching.MatchingService;
//import service.validator.OrderValidationEngine;
//import service.validator.OrderValidatorService;
//
//import java.sql.Timestamp;
//
//@Data
//@AllArgsConstructor
//public class OrderService {
//
//    private final InMemoryOrderBook inMemoryOrderBook;
//    private final InMemoryTrade inMemoryTrade;
//    private final MatchingService matchingService;
//    private final OrderValidatorService orderValidatorService;
//
//    private int totalOrdersLoaded = 0;
//    private int rejectedOrders = 0;
//    private int validOrders = 0;
//
//    //  CUSTOM ZERO-ARG CONSTRUCTOR
//    public OrderService() {
//        this.inMemoryOrderBook = new InMemoryOrderBook();
//        this.inMemoryTrade = new InMemoryTrade();
//        this.matchingService = new MatchingService(inMemoryOrderBook, inMemoryTrade);
//        this.orderValidatorService = new OrderValidationEngine();
//
//        // counters automatically = 0
//    }
//
//    public void incrementTotalOrders() { totalOrdersLoaded++; }
//    public void incrementRejectedOrders() { rejectedOrders++; }
//    public void incrementValidOrders() { validOrders++; }
//
//    public Order submitCsvOrder(String orderId, String traderId, TradeType tradeType,
//                                OrderType orderType, double price, long quantity,
//                                String country, Timestamp timestamp) {
//
//        incrementTotalOrders();
//
//        Order order = new Order(orderId, traderId, tradeType, orderType, price, quantity, country, timestamp);
//
//        try {
//            orderValidatorService.validate(order);
//            incrementValidOrders();
//
//            inMemoryOrderBook.saveOrder(order);
//            matchingService.match(order);
//
//            return order;
//        }catch (Exception e) {
//            incrementRejectedOrders();
//            return null;   // not throwing anything
//        }
//    }
//}