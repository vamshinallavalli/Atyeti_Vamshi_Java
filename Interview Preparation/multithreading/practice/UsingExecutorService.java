package practice;

import java.util.concurrent.*;

public class UsingExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service= Executors.newSingleThreadExecutor();


        Callable<Integer> task=()->{
            Thread.sleep(1000);
            return 24;
        };

        Future<Integer> future=service.submit(task);

        System.out.println(future.get());

//        service.submit(()-> System.out.println("Hello"));
//
        service.shutdown();
    }
}
