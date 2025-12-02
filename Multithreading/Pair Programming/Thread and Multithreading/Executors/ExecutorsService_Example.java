package Executors;

import java.util.concurrent.*;

// Reuses threads → faster, avoids creating threads manually.
public class ExecutorsService_Example {
    public static void main(String[] args) {

        // A fixed number of threads.
        ExecutorService service = Executors.newFixedThreadPool(2);

        // Creates unlimited threads based on demand.
        ExecutorService service1 = Executors.newCachedThreadPool();

        // One thread executes tasks sequentially.
        ExecutorService service2 = Executors.newSingleThreadExecutor();

        // For delayed or periodic tasks.
        ExecutorService service3 = Executors.newScheduledThreadPool(2);


        service.submit(() -> System.out.println("Task 1"));
        service.submit(() -> System.out.println("Task 2"));

        service.shutdown();

    }
}
