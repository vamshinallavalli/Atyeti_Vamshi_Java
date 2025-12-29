package service;

import exception.OrderException;
import inmemory.OrderBook;
import inmemory.SimpleOrderBook;
import inmemory.InMemoryTrade;
import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reports.ReportService;
import service.matching.Matching;
import service.matching.MatchingService;
import service.validator.OrderValidationEngine;
import service.validator.OrderValidatorService;

import java.sql.Timestamp;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    // Core dependencies (DIP compliant)
    private final OrderBook orderBook;
    private final InMemoryTrade tradeBook;
    private final Matching matchingStrategy;
    private final OrderValidatorService validator;

    // Metrics
    private int totalOrdersLoaded = 0;
    private int rejectedOrders = 0;
    private int validOrders = 0;

    // Duplicate order protection
    private final Set<String> seenOrderIds = ConcurrentHashMap.newKeySet();


    public OrderService() {
        this.orderBook = new SimpleOrderBook();
        this.tradeBook = new InMemoryTrade();
        this.validator = new OrderValidationEngine();
        this.matchingStrategy = new MatchingService(orderBook, tradeBook);
    }

    // Main public API

    public synchronized Order submitOrder(String orderId,
                                          String traderId,
                                          TradeType tradeType,
                                          OrderType orderType,
                                          double price,
                                          long quantity,
                                          String country,
                                          Timestamp timestamp) {

        totalOrdersLoaded++;

        // Duplicate order ID check
        if (!seenOrderIds.add(orderId)) {
            rejectedOrders++;
            log.warn("DUPLICATE ORDER ID REJECTED: {}", orderId);
            Order rejected = new Order();
            rejected.setStatus(OrderStatus.REJECTED);
            return rejected;
        }

        Order order = new Order(orderId, traderId, tradeType,
                orderType, price, quantity,
                country, timestamp);

        try {
            validator.validate(order);
            validOrders++;

            matchingStrategy.match(order);
            return order;

        } catch (OrderException e) {
            rejectedOrders++;
            order.setStatus(OrderStatus.REJECTED);
            log.warn("REJECTED {}: {}", orderId, e.getMessage());
            return order;
        }
    }

    // CSV loader / reuse
    public Order submitCsvOrder(String orderId, String traderId,
                                TradeType tradeType, OrderType orderType,
                                double price, long quantity,
                                String country, Timestamp timestamp) {

        return submitOrder(orderId, traderId, tradeType,
                orderType, price, quantity,
                country, timestamp);
    }

    // REPORT SERVICE
    public OrderBook getOrderBook() {
        return orderBook;
    }

    public InMemoryTrade getTradeRepository() {
        return tradeBook;
    }

    // Metrics getters
    public int getTotalOrdersLoaded() { return totalOrdersLoaded; }
    public int getRejectedOrders()    { return rejectedOrders; }
    public int getValidOrders()       { return validOrders; }

    /**
     * Convenience method to generate CSV reports
     */
    public void generateCsvReports() throws Exception {
        ReportService reportService = new ReportService(orderBook);
        reportService.generateAllCsvReports();
    }
}
