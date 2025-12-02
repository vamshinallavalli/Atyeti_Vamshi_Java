package Async;

import java.util.concurrent.*;

public class Async_Example {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Integer> result = service.submit(() -> 10 + 20);

        System.out.println(result.get()); // 30

        service.shutdown();

    }
}
