package basic;

public class ThreadLifeCycle {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("Child: I'm alive! State = " + Thread.currentThread().getState());
            try { Thread.sleep(3000); } catch (Exception e) {}
            System.out.println("Child: Bye!");
        }, "Demo-Thread");

        System.out.println("Before start: " + t.getState());     // NEW
        t.start();
        System.out.println("After start: " + t.getState());      // RUNNABLE

        Thread.sleep(1000);
        System.out.println("After 1 sec: " + t.getState());      // TIMED_WAITING (because of sleep)

        t.join();
        System.out.println("After join: " + t.getState());       // TERMINATED


        t.start();
        System.out.println("Before start: " + t.getState());     // NEW

    }
}