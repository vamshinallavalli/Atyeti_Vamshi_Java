package Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool{
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        System.out.println("Task will run after 3 seconds...");

        scheduler.schedule(() -> {
            System.out.println("Delayed task executed by " +
                    Thread.currentThread().getName());
        }, 3, TimeUnit.SECONDS);

        scheduler.shutdown();
    }
}
