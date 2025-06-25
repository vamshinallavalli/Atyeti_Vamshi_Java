package tasks;

public class PrintNumbersUsingMultipleThreads {
    private static final Object lock=new Object();
    public static void main(String[] args) {

        Thread evenNumber=new Thread(()-> {
            for (int i = 1; i <= 10; i++) {
                synchronized (lock) {
                    if (i % 2 == 0) {
                        System.out.println("Even: "+i);
                        lock.notify();
                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });

        Thread oddNumber=new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                synchronized (lock) {
                    if (i % 2!= 0) {
                        System.out.println("Odd: "+i);
                        lock.notify();
                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }}
                }
            }
        });
        evenNumber.start();
        oddNumber.start();
    }
}
