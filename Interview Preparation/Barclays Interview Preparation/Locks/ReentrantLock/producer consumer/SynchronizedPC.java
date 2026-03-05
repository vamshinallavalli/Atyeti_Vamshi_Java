import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {

    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 1;

    public synchronized void produce(int value) throws InterruptedException {

        while (queue.size() == capacity) {
            System.out.println("Buffer full, Producer waiting...");
            wait();   // release lock + wait
        }

        queue.add(value);
        System.out.println("Produced: " + value);

        notify(); // wake consumer

      //  notify(); // May wake another producer instead of consumer

      //  This causes unnecessary context switching.
    }

    public synchronized void consume() throws InterruptedException {

        while (queue.isEmpty()) {
            System.out.println("Buffer empty, Consumer waiting...");
            wait();
        }

        int val = queue.poll();
        System.out.println("Consumed: " + val);

        notify(); // wake producer
    }
}

public class SynchronizedPC {
    public static void main(String[] args) {

        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            int i = 1;
            while (true) {
                try {
                    buffer.produce(i++);
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        });

        producer.interrupt();

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    buffer.consume();
                    Thread.sleep(800);
                } catch (Exception e) {
                }
            }
        });

        producer.start();
        consumer.start();
    }
}