package inmemory;

import model.Order;
import model.TradeType;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public interface OrderBook {

    PriorityBlockingQueue<Order> getBuyQueue(TradeType tradeType);

    PriorityBlockingQueue<Order> getSellQueue(TradeType tradeType);

    void addOrder(Order order);

    List<Order> getAllOrders();
}

/*

OrderBook → stores pending BUY & SELL orders

TradeBook → stores executed trades
 */