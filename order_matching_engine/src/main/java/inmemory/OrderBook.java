package inmemory;

import model.Order;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class OrderBook {

    private final PriorityQueue<Order> buyQueue;
    private final PriorityQueue<Order> sellQueue;

    public OrderBook(PriorityQueue<Order> buyQueue, PriorityQueue<Order> sellQueue) {
        this.buyQueue = buyQueue;
        this.sellQueue = sellQueue;
    }

    public static OrderBook create() {
        return new OrderBook(
                new PriorityQueue<>(Comparator
                        .comparingDouble(Order::getPrice).reversed()
                        .thenComparing(Order::getTimestamp)),
                new PriorityQueue<>( Comparator
                        .comparingDouble(Order::getPrice)
                        .thenComparing(Order::getTimestamp))
        );
    }


    // FIXED RETURN TYPES
    public Queue<Order> getBuyQueue() {
        return buyQueue;
    }

    public Queue<Order> getSellQueue() {
        return sellQueue;
    }
}