package Scenario_8;
/*
Java Scenario 8:  Producer Consumer Problem
One thread produces integers into a shared queue, another consumes them.
Implement using wait()
and notify() for thread coordination.
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Producer
class Producer1 implements Runnable {
    private BlockingQueue<Integer> queue;

    Producer1(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                queue.put(i);   // blocks if queue is full
                System.out.println("Produced: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Consumer
class Consumer1 implements Runnable {
    private BlockingQueue<Integer> queue;

    Consumer1(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                int value = queue.take(); // blocks if queue is empty
                System.out.println("Consumed: " + value);
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerBlockingQueueDemo {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread producerThread = new Thread(new Producer1(queue));
        Thread consumerThread = new Thread(new Consumer1(queue));

        producerThread.start();
        consumerThread.start();
    }
}

