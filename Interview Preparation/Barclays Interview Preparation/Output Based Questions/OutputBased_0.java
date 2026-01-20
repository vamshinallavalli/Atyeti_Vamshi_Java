

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
 Increment the shared counter with threads
Create 10 threads, each updating a shared counter. The goal is for the final count to be 10,000.
Solution: Use AtomicInteger for thread-safe increments.
We’ll look at two examples:
1. Using a normal int (shows an incorrect result due to race conditions).
2. Using AtomicInteger (produces the correct result).
 */
public class OutputBased_0 {
    final static AtomicInteger count=new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service= Executors.newFixedThreadPool(10);

        for(int i=0;i<10000;i++) {

            service.submit(() -> {
                count.incrementAndGet();
            });

        }
        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("After 10 threads working on shared resource count is : "+count.get());

    }

}























//         service.awaitTermination(5, TimeUnit.SECONDS);

//   shutdown() initiates executor shutdown, while awaitTermination() is required to block and wait until all running tasks complete or timeout occurs.

