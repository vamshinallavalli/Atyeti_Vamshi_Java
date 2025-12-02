public class DeadLock{
    public static void main(String[] args) {
        final Object lock1=new Object();
        final Object lock2=new Object();

        Thread t1=new Thread(()-> {

            synchronized (lock1) {
                System.out.println("Thread 1 acquired lock1");
//                try {
//                   // Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

                System.out.println("Thread 1 is waiting for lock2");


                synchronized (lock2) {
                    System.out.println("Thread 1 is waiting for lock2");
                }
            }
        }
        );

        Thread t2=new Thread(()-> {
            synchronized (lock1) {
                System.out.println("Thread 2 acquired lock2");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

                System.out.println("Thread 2 is waiting for lock1");

                synchronized (lock2) {
                    System.out.println("Thread 2 is waiting for lock1");
                }
            }
        });

        t1.start();
        t2.start();

    }
}