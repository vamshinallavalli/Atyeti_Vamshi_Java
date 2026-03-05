import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class TimeoutTask {

    ReentrantLock lock = new ReentrantLock();

    public void work() {
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired lock");
                    Thread.sleep(2000);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to acquire lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TryLockTimeoutExample {
    public static void main(String[] args) {

        TimeoutTask task = new TimeoutTask();

        Thread t1 = new Thread(() -> task.work(), "Thread-1");
        Thread t2 = new Thread(() -> task.work(), "Thread-2");

        t1.start();
        t2.start();
    }
}