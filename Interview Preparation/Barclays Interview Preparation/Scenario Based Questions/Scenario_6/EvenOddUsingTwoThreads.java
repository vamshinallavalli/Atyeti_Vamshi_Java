package Scenario_6;
/*
 Printing Even and Odd Numbers with Two Threads
Two threads should print numbers from 1 to 20. One prints even numbers, the other prints odd
numbers.
Hint:
 Use synchronization to ensure correct order
 */
public class EvenOddUsingTwoThreads{

    int limit=100;
    int start=1;

    public static void main(String[] args) {
        EvenOddUsingTwoThreads obj=new EvenOddUsingTwoThreads();

        Thread t1=new Thread(()-> {
            try {
                obj.even();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        Thread t2=new Thread(()-> {
            try {
                obj.odd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t2.start();


    }

    private synchronized void odd() throws InterruptedException {
        while(start<=limit){
            if(start%2==0) {
                wait();
            }else{
                System.out.println("Odd: " + start);
                start++;
                notifyAll();
            }
        }

    }

    private synchronized void even() throws InterruptedException {
        while(start<=limit){
            if(start%2!=0) {
                wait();
            }else{
                        System.out.println("Even: " + start);
                        start++;
                        notifyAll();
                    }
            }
        }
    }

