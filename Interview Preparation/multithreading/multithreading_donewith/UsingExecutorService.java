package multithreading_donewith;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsingExecutorService {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Number: " + i + " [" + Thread.currentThread().getName() + "]");
                try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        });

        executor.submit(() -> {
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Letter: " + c + " [" + Thread.currentThread().getName() + "]");
                try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        });

        executor.shutdown(); // Accept no new tasks

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Done!");
    }
}