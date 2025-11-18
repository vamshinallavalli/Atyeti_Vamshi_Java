import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//Use CompletableFuture when you need:
//
// Asynchronous processing
// Non-blocking operations
// Chaining multiple tasks
// Running tasks in parallel
// Combining multiple results
// Proper error handling

public class Using_CompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        // Simple Run Async Task
        CompletableFuture<Void> future =
                CompletableFuture.runAsync(() -> {
                    System.out.println("Running task in background...");
                });


        // Callable like Example return value
        CompletableFuture<Integer> future1 =
                CompletableFuture.supplyAsync(() -> {
                    return 10 + 20;
                });

        System.out.println(future1.get());


        // Chaining
        CompletableFuture<Integer> future2 =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenApply(n -> n * 2)
                        .thenApply(n -> n + 5);

        System.out.println(future2.get());

        // Non-blocking callback
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(result -> System.out.println("Result = " + result));


        // Run two tasks in parallel and combined results
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combined =
                f1.thenCombine(f2, (a, b) -> a + b);

        System.out.println(combined.get());


        // Exception Handling
        CompletableFuture<Object> future3 =
                CompletableFuture.supplyAsync(() -> {
                    throw new RuntimeException("Error!!");
                }).exceptionally(ex -> {
                    System.out.println(ex.getMessage());
                    return 0;
                });

        System.out.println(future.get());



    }
}
