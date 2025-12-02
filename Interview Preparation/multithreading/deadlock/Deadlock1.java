package deadlock;

public class Deadlock1{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Using Main Thread......");

        Thread t=Thread.currentThread();
        t.join();

        System.out.println("Other Thread: "+t.getName());
    }
}
