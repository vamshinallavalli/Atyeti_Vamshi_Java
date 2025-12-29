package practice;

import java.util.concurrent.atomic.AtomicLong;

public class RaceConditionSynchronized extends Thread{

    static AtomicLong count=new AtomicLong();
    public static void main(String[] args) throws InterruptedException {


        RaceConditionSynchronized t1=new RaceConditionSynchronized();
        RaceConditionSynchronized t2=new RaceConditionSynchronized();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }


    public void run(){
        for(int i=0;i<1000;i++){
            increment();
        }
    }

    public void increment(){
        count.incrementAndGet();
    }
}
