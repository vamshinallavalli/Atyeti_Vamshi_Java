import java.util.concurrent.locks.*;

class SharedResource {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    boolean available = false;

    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (available) {
                condition.await();
            }
            available = true;
            System.out.println("Produced");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (!available) {
                condition.await();
            }
            available = false;
            System.out.println("Consumed");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
