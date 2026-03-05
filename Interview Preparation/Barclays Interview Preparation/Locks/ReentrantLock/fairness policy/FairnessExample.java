import java.util.concurrent.locks.ReentrantLock;

class FairLockTask {

    // true → Fair lock (FIFO)
    ReentrantLock lock = new ReentrantLock(true);

    public void runTask() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired lock");
            Thread.sleep(1000);
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }
}

public class FairnessExample {
    public static void main(String[] args) {

        FairLockTask task = new FairLockTask();

        Runnable r = () -> task.runTask();

        for (int i = 1; i <= 5; i++) {
            new Thread(r, "Thread-" + i).start();
        }
    }
}