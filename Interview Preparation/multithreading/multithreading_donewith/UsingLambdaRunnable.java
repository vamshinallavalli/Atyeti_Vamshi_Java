package multithreading_donewith;

public class UsingLambdaRunnable{
    public static void main(String[] args) {
        Runnable numberTask = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Number: " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        };

        Runnable letterTask = () -> {
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Letter: " + c);
                try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        };

        Thread t1 = new Thread(numberTask, "NumberThread");
        Thread t2 = new Thread(letterTask, "LetterThread");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Done!");
    }
}