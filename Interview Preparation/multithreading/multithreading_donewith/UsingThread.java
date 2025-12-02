package multithreading_donewith;

public class UsingThread {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        LetterThread t2 = new LetterThread();

        t1.start();
        t2.start();

        // Optional: wait for them to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done!");
    }
}

class NumberThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Number: " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

class LetterThread extends Thread {
    @Override
    public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("Letter: " + c);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}