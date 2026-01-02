package Synchronization;

public class Synchronized1 extends Thread{

    static int count=0;
    public static void main(String[] args) throws InterruptedException {
        Synchronized1 s1=new Synchronized1();
        s1.start();

        Synchronized1 s2=new Synchronized1();
        s2.start();

        s1.join();
        s2.join();

        System.out.println(count);
    }

    public void run(){
        for(int i=0;i<1000;i++){
            increment();
        }
    }

    public synchronized static void increment(){
        count++;
    }
}
