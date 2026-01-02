package Synchronization;

public class Synchronized2 extends Thread{
    static int start=0;
    static int limit=10;

    public static void main(String[] args) throws InterruptedException {

        Synchronized2 s=new Synchronized2();

        Thread s1=new Thread(()-> {
            try {
                s.even();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread s2=new Thread(()-> {
            try {
                s.odd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        s1.start();
        s2.start();
    }

    public synchronized void even() throws InterruptedException {
        while(start<=limit){
            if(start%2==0){
                System.out.println("Even : "+start);
                wait();
            }
            start++;
            notify();

        }
    }

    public synchronized void odd() throws InterruptedException {
        while(start<=limit){
            if(start%2!=0){
                System.out.println("Odd : "+start);
                wait();
            }
            start++;
            notify();
        }
    }
}
