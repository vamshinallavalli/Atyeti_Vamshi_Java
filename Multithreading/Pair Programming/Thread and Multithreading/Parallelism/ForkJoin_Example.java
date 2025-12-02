package Parallelism;

import java.util.concurrent.ForkJoinPool;

public class ForkJoin_Example {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        pool.submit(() ->
                System.out.println("Fork Join Running")
        ).join();

    }
}
