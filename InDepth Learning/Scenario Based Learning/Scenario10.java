/*
Java Scenario 10:  Increment the shared counter with threads
Create 10 threads, each updating a shared counter. The goal is for the final count to be
10,000.
Solution: Use AtomicInteger for thread-safe increments.
We’ll look at two examples:
1. Using a normal int (shows an incorrect result due to race conditions).
2. Using AtomicInteger (produces the correct result).
 */

import java.util.concurrent.atomic.AtomicInteger;

public class Scenario10 {
    //static int count=0;
    static AtomicInteger count=new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {

        Scenario10 scenario=new Scenario10();
        Thread t1=new Thread(()->scenario.increment());
        Thread t2=new Thread(()->scenario.increment());
        Thread t3=new Thread(()->scenario.increment());
        Thread t4=new Thread(()->scenario.increment());
        Thread t5=new Thread(()->scenario.increment());
        Thread t6=new Thread(()->scenario.increment());
        Thread t7=new Thread(()->scenario.increment());
        Thread t8=new Thread(()->scenario.increment());
        Thread t9=new Thread(()->scenario.increment());
        Thread t10=new Thread(()->scenario.increment());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        t9.join();
        t10.join();


        System.out.println("Final count : "+count);
    }

    private void increment() {
        for(int i=0;i<1000;i++){
           // count++;
            count.incrementAndGet();
        }
    }
}
