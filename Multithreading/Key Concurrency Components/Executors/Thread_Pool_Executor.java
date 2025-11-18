import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Thread_Pool_Executor {

    // Fixed Thread Pool
    // A fixed number of threads.
    ExecutorService executor = Executors.newFixedThreadPool(3);

    // Cached Thread Pool
    // Creates unlimited threads based on demand.
    ExecutorService executors = Executors.newCachedThreadPool();

    // Single Thread Executor
    // One thread executes tasks sequentially.
    ExecutorService executorss = Executors.newSingleThreadExecutor();

    // Scheduled Thread Pool
    // For delayed or periodic tasks.
    ScheduledExecutorService executorsss = Executors.newScheduledThreadPool(2);





}
