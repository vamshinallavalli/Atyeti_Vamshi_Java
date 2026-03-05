import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SharedBufferLock {

    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 1;

    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void produce(int value) throws InterruptedException {

        lock.lock();
        try {

            while (queue.size() == capacity) {
                System.out.println("Buffer full, Producer waiting...");
                notFull.await();
            }

            queue.add(value);
            System.out.println("Produced: " + value);

            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {

        lock.lock();
        try {

            while (queue.isEmpty()) {
                System.out.println("Buffer empty, Consumer waiting...");
                notEmpty.await();
            }

            int val = queue.poll();
            System.out.println("Consumed: " + val);

            notFull.signal();

        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockPC {
    public static void main(String[] args) {

        SharedBufferLock buffer = new SharedBufferLock();

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