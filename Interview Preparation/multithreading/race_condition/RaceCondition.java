package race_condition;

public class RaceCondition extends Thread {
    static int count = 0;

    public static synchronized void increment() {
        count++;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RaceCondition t1 = new RaceCondition();
        RaceCondition t2 = new RaceCondition();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + count);
    }
}
