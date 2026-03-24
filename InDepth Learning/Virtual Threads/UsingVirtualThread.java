import jdk.jshell.spi.ExecutionControl;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingVirtualThread {
    public static void main(String[] args) throws InterruptedException {

//        try (var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
//            executor.submit(() -> {
//                System.out.println("Task running");
//            });
//        }


        Thread t=Thread.startVirtualThread(() -> {
            System.out.println("Hello from virtual thread!");
        });

        t.join();
    }
}
