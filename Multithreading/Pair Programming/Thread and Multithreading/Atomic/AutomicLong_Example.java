package Atomic;
import java.util.concurrent.atomic.AtomicLong;
public class AutomicLong_Example {
    public static void main(String[] args) throws InterruptedException {
        AtomicLong counter = new AtomicLong(0);

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();  // Atomic operation
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count = " + counter.get());
    }
}
