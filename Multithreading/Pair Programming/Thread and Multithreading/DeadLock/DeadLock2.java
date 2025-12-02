package DeadLock;

public class DeadLock2 {
    public static void main(String[] args) throws InterruptedException {

        Thread thread=Thread.currentThread();

        System.out.println("Main Thread Started....");

        thread.join();

        System.out.println("Our thread started....");
    }
}
