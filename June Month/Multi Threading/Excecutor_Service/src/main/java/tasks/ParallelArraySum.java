package tasks;

import java.util.concurrent.*;
import java.util.*;

public class ParallelArraySum {

    static class ArraySumTask implements Callable<Integer> {
        int[] arr;
        int start, end;

        ArraySumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        public Integer call() {
            int sum = 0;
            for (int i = start; i < end; i++) sum += arr[i];
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;

        int numThreads = 5;
        int chunkSize = arr.length / numThreads;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < arr.length; i += chunkSize) {
            int end = Math.min(i + chunkSize, arr.length);
            ArraySumTask task = new ArraySumTask(arr, i, end);
            futures.add(executor.submit(task));
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        System.out.println("Total Sum = " + totalSum);
    }
}