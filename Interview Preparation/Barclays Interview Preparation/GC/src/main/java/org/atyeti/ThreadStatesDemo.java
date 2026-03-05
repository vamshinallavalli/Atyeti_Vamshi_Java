package org.atyeti;

public class ThreadStatesDemo {

    static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        // 1️⃣ NEW State
        Thread newThread = new Thread(() -> {
            System.out.println("New Thread running");
        });

        System.out.println("State of newThread: " + newThread.getState());
        // Not started yet → NEW


        // 2️⃣ RUNNABLE State
        Thread runnableThread = new Thread(() -> {
            while (true) {
                // Busy loop to stay RUNNABLE
            }
        }, "RUNNABLE-THREAD");
        runnableThread.start();


        // 3️⃣ TIMED_WAITING (sleep)
        Thread timedWaitingThread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {}
        }, "TIMED_WAITING-THREAD");
        timedWaitingThread.start();


        // 4️⃣ WAITING (wait)
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();   // WAITING
                } catch (InterruptedException e) {}
            }
        }, "WAITING-THREAD");
        waitingThread.start();


        // 5️⃣ BLOCKED (lock contention)
        Thread blockedThread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {}
            }
        }, "BLOCKED-THREAD-1");

        Thread blockedThread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Blocked thread acquired lock");
            }
        }, "BLOCKED-THREAD-2");

        blockedThread1.start();
        Thread.sleep(100); // ensure t1 gets lock first
        blockedThread2.start();


        // 6️⃣ TERMINATED
        Thread terminatedThread = new Thread(() -> {
            System.out.println("Terminated thread executed");
        }, "TERMINATED-THREAD");

        terminatedThread.start();
        terminatedThread.join(); // wait to finish

        System.out.println("State of terminatedThread: "
                + terminatedThread.getState());


        // Keep main alive so VisualVM can observe
        Thread.sleep(30000);
    }
}
