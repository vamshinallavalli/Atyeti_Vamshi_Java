package com.atyeti;

public class Synchronization {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }
        System.out.println(counter.getCount());
    }
}
//-----------------------------------------------------------------------------------------------------------------
class Counter {
    private int count=0;

    public synchronized void increment(){
        count++;
        //System.out.println("Incrementing by "+Thread.currentThread().getName()+" count: "+count);
    }

    public int getCount(){
        return count;
    }

}
//----------------------------------------------------------------------------------------------------------------
class MyThread extends Thread{
    private Counter counter;

    public MyThread(Counter counter){
        this.counter=counter;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            counter.increment();
        }
        // System.out.println(Thread.currentThread().getName()+" completed");
    }
}
