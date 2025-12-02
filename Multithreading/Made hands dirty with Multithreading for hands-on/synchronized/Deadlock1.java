public class Deadlock1 {
    public static void main(String[] args) throws InterruptedException {

       Thread t1=Thread.currentThread();

        System.out.println("Main Thread Started..."+t1.getName());

        // join() tells the current thread: “Wait until other thread completes.”
        t1.join();

        System.out.println("Main Thread Completed...."+t1.getName());
    }
}
