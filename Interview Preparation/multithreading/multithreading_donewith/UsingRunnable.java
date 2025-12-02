package multithreading_donewith;

public class UsingRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new NumberTask());
        Thread t2 = new Thread(new LetterTask());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed!");
    }
}

class NumberTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Number: " + i + " - " + Thread.currentThread().getName());
            try { Thread.sleep(400); } catch (InterruptedException e) {}
        }
    }
}

class LetterTask implements Runnable {
    @Override
    public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("Letter: " + c + " - " + Thread.currentThread().getName());
            try { Thread.sleep(400); } catch (InterruptedException e) {}
        }
    }
}