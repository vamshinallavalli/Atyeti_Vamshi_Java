import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService es =
                new ThreadPoolExecutor(
                        2, 4,
                        60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>()
                );

        es.submit(()-> System.out.println("Hello"));

        es.shutdown();
    }
}
