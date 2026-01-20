package Scenario_8;

import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 5;

    // Producer method
    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // wait if queue is full
        }

        queue.add(value);
        System.out.println("Produced: " + value);

        notify(); // notify consumer
    }

    // Consumer method
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // wait if queue is empty
        }

        int value = queue.poll();
        System.out.println("Consumed: " + value);

        notify(); // notify producer
        return value;
    }
}

class Producer extends Thread {
    private SharedQueue sharedQueue;

    Producer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                sharedQueue.produce(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private SharedQueue sharedQueue;

    Consumer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                sharedQueue.consume();
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();

        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);

        producer.start();
        consumer.start();
    }
}
