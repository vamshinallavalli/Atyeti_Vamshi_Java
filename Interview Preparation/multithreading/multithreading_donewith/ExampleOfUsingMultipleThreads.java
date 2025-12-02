package multithreading_donewith;

public class ExampleOfUsingMultipleThreads {
    private boolean isOddTurn = true;
    private final Object lock = new Object();

    public static void main(String[] args) {
        ExampleOfUsingMultipleThreads obj = new ExampleOfUsingMultipleThreads();

        Thread t1 = new Thread(() -> {
            try {
                obj.printEven();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                obj.printOdd();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();

        // Optional: wait for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void printEven() throws InterruptedException {
        synchronized (lock) {
            for (int i = 2; i <= 10; i += 2) {
                while (isOddTurn) {
                    lock.wait();
                }
                System.out.println("Even: " + i);
                isOddTurn = true;
                lock.notify();
            }
        }
    }

    public void printOdd() throws InterruptedException {
        synchronized (lock) {
            for (int i = 1; i <= 9; i += 2) {
                while (!isOddTurn) {       // Wait if it's even's turn
                    lock.wait();
                }
                System.out.println("Odd: " + i);
                isOddTurn = false;         // Now even's turn
                lock.notify();
            }
        }
    }
}