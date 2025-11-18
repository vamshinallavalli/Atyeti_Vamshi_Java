import java.util.concurrent.*;

public class Using_Callable {
    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 50;
        };

        Future<Integer> future = service.submit(task);

        System.out.println("Task submitted...");

        int result = future.get(); // waits for result
        System.out.println("Result = " + result);

        service.shutdown();
    }
}