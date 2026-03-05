import java.util.concurrent.locks.ReentrantLock;

class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}

public class SynchronizedExample {
    public static void main(String[] args) throws Exception {

        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 10000000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.count);
    }
}