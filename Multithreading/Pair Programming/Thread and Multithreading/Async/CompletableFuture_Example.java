package Async;

import java.util.concurrent.CompletableFuture;

public class CompletableFuture_Example {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(System.out::println);
    }
}
