package Scheduling;

import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorService_Example {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(
                () -> System.out.println("Running..."),
                0,
                1,
                TimeUnit.SECONDS
        );

    }
}
