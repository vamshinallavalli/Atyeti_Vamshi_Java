package ExceutorService;

import java.util.concurrent.*;

public class ExecutorService1 {
    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            Future<String> future = service.submit(() -> {
                System.out.println("Running in: " +
                        Thread.currentThread().getName());
                return "vamshi";
            });

            System.out.println("Result: " + future.get());
        }

        service.shutdown();
    }
}
