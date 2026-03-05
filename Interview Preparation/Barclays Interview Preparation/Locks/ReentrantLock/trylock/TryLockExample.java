import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {

    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        System.out.println("Thread-1 acquired lock1");
                        sleep(1000);

                        System.out.println("Thread-1 trying for lock2");

                        //  DEADLOCK VERSION
                         //lock2.lock();

                        //  SAFE VERSION
                        if (lock2.tryLock()) {
                            try {
                                System.out.println("Thread-1 acquired lock2");
                                break; // work done
                            } finally {
                                lock2.unlock();
                            }
                        }

                    } finally {
                        lock1.unlock();
                    }
                }
                sleep(100); // retry delay
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        System.out.println("Thread-2 acquired lock2");
                        sleep(1000);

                        System.out.println("Thread-2 trying for lock1");

                        //  DEADLOCK VERSION
                        // lock1.lock();

                        //  SAFE VERSION
                        if (lock1.tryLock()) {
                            try {
                                System.out.println("Thread-2 acquired lock1");
                                break; // work done
                            } finally {
                                lock1.unlock();
                            }
                        }

                    } finally {
                        lock2.unlock();
                    }
                }
                sleep(100); // retry delay
            }
        });

        t1.start();
        t2.start();
    }

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}








/*
Main reasons:

 Avoid deadlocks

 Avoid blocking threads

 Improve responsiveness

 Implement timeout logic

 Build non-blocking systems
 */



