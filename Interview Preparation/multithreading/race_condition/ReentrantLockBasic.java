package race_condition;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockBasic {
    private static int count = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                addOne();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count = " + count);
    }

    private static void addOne() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
