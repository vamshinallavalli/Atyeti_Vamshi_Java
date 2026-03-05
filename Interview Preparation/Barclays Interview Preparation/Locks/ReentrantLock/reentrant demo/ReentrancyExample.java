import java.util.concurrent.locks.ReentrantLock;

class ReentrantDemo {

    ReentrantLock lock = new ReentrantLock();

    public void outer() {
        lock.lock();
        try {
            System.out.println("Outer method");
            inner();
        } finally {
            lock.unlock();
        }
    }

    public void inner() {
        lock.lock();
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrancyExample {
    public static void main(String[] args) {
        ReentrantDemo demo = new ReentrantDemo();
        demo.outer();
    }
}