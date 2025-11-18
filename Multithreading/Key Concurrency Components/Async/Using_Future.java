import java.util.concurrent.*;

public class Using_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service= Executors.newFixedThreadPool(2);

        Callable<Integer> task = () ->{
            Thread.sleep(2000);
            return 10+20;
        };

        Future<Integer> future = service.submit(task);

        System.out.println("Task Submitted....");

        Integer result=future.get();
        System.out.println("Result: "+result);

        service.shutdown();
    }
}


//Methods of Future (very important for interviews)

//Method	                          Meaning
//get()	                    Waits till task completes and returns result
//get(timeout, unit)	    Wait for limited time
//isDone()	                Check if task finished
//cancel()	                Cancel task
//isCancelled()	            Check if cancelled
