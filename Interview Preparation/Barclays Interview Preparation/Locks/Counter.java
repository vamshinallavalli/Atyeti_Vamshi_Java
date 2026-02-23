import java.util.concurrent.locks.ReentrantLock;

class Counter {
    int count = 0;
    ReentrantLock lock=new ReentrantLock();

    void increment() {


        lock.lock();
        try {
            count++;
        }

        finally {
            lock.unlock();
        }

    }
}

