
/*
Java Scenario 6: Printing Even and Odd Numbers with Two Threads
Two threads should print numbers from 1 to 20. One prints even numbers, the other
prints odd numbers.
Hint:
 Use synchronization to ensure correct order
 */
class Scenario6{
    static int start = 1, end = 20;

    public static void main(String[] args) {

        Scenario6 obj = new Scenario6();

        Thread t1 = new Thread(() -> {
            try {
                obj.odd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                obj.even();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }

    public synchronized void odd() throws InterruptedException {
        while(start < end){
            if(start % 2 == 0){
                wait();
            }

            System.out.println("Odd : " + start);
            start++;
            notify();
        }
    }

    public synchronized void even() throws InterruptedException {
        while(start <end){
            if(start % 2 != 0){
                wait();
            }

            System.out.println("Even : " + start);
            start++;
            notify();
        }
    }
}