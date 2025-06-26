import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class DeadlockFree {
    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        ExecutorService executorService= Executors.newFixedThreadPool(5);

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                if (lock1.tryLock(500, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println(threadName + ": Acquired lock1");
                        Thread.sleep(100);
                        if (lock2.tryLock(500, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println(threadName + ": Acquired lock2");
                            } finally {
                                lock2.unlock();
                            }
                        } else {
                            System.out.println(threadName + ": Couldn't acquire lock2, avoiding deadlock");
                        }
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println(threadName + ": Couldn't acquire lock1, avoiding deadlock");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for(int i=0;i<999;i++){
        executorService.submit(task);}
        executorService.shutdown();


//        Thread t1 = new Thread(task, "Thread 1");
//        Thread t2 = new Thread(task, "Thread 2");

//        t1.start();
//        t2.start();
    }
}
