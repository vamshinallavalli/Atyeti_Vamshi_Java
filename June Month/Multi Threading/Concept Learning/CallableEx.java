package com.atyeti;

import java.util.concurrent.*;

public class CallableEx {
    //Callable returns a value, unlike Runnable
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> System.out.println("Thread task"));
        Callable<Integer> task = () -> 10 + 20;
        Future<Integer> future = executor.submit(task);
        System.out.println(future.get());

        executor.shutdown();

    }
}
