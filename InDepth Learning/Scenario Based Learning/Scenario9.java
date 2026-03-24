/*
Java Scenario 9:  Simulating the deadlock
Create two threads, each trying to lock two resources in opposite order, causing a
deadlock. Then show how to avoid it.
 */

public class Scenario9 {

    private  final Object lock1=new Object();
    private final Object lock2=new Object();

    public static void main(String[] args) {

        Scenario9 scenario=new Scenario9();

        Thread t1=new Thread(()->scenario.acquireLock1());
        Thread t2=new Thread(()->scenario.acquireLock2());

        t1.start();
        t2.start();
    }

    private void acquireLock2() {
        synchronized (lock1){
            System.out.println("Thread 1 acquired lock 1 : "+Thread.currentThread().getName());

            synchronized (lock2){
                System.out.println("Thread 1 acquired lock 2 : "+Thread.currentThread().getName());
            }
        }
    }

    private void acquireLock1() {
        synchronized (lock2){
            System.out.println("Thread 2 acquired lock 1 : "+Thread.currentThread().getName());

            synchronized (lock1){
                System.out.println("Thread 2 acquired lock 2 : "+Thread.currentThread().getName());
            }
        }
    }
}
