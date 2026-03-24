import java.util.LinkedList;
import java.util.Queue;

public class Scenario8 {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        int capacity = 5;

        Producer producer = new Producer(queue, capacity);
        Consumer consumer = new Consumer(queue, capacity);

        Thread t1 = new Thread(() -> {
            try {
                producer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                consumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}

class Producer {

    private Queue<Integer> queue;
    private int capacity;

    public Producer(Queue<Integer> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    public synchronized void produce() throws InterruptedException {

        int value = 1;

        while (true) {

            synchronized (queue) {

                while (queue.size() == capacity) {
                    queue.wait();
                }

                System.out.println("Produced: " + value);

                queue.add(value++);

                queue.notify();
            }

            Thread.sleep(500);
        }
    }
}

class Consumer {

    private Queue<Integer> queue;
    private int capacity;

    public Consumer(Queue<Integer> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    public synchronized void consume() throws InterruptedException {

        while (true) {

            synchronized (queue) {

                while (queue.isEmpty()) {
                    queue.wait();
                }

                int value = queue.remove();

                System.out.println("Consumed: " + value);

                queue.notify();
            }

            Thread.sleep(800);
        }
    }
}