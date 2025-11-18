import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor_Service {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService= Executors.newFixedThreadPool(3);

        for(int t=1;t<=3;t++) {
            executorService.submit(() -> {
                for (int i = 0; i < 500; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
