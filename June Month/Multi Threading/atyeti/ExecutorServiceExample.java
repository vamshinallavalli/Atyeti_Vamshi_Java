package com.atyeti;

import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        // Step 1: Create ExecutorService with a fixed thread pool of size 2
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Step 2: Define two tasks using Callable (so they can return values)
        Callable<String> task1 = () -> {
            Thread.sleep(1000); // Simulate some work
            return "Task 1 completed";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(5000); // Simulate some work
            return "Task 2 completed";
        };

        try {
            // Step 3: Submit tasks to the executor
            Future<String> future1 = executor.submit(task1);
            Future<String> future2 = executor.submit(task2);

            // Step 4: Get the results (waits if necessary)
            System.out.println(future1.get());
            System.out.println(future2.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Always shut down the executor
            executor.shutdown();
        }
    }
}