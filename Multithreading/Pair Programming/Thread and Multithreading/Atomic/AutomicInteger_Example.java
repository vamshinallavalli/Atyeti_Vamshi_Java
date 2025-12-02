package Atomic;

import java.util.concurrent.atomic.AtomicInteger;

// Thread-safe without locks.
public class AutomicInteger_Example {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);

        Runnable task=(()->{
            for(int i=0;i<1000;i++){
                count.incrementAndGet();
            }
        });

        Thread t1=new Thread(task);
        Thread t2=new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.get());

    }
}
