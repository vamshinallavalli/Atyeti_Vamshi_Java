//package org.atyeti;
//
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class Main{
//
//    private final Lock lock = new ReentrantLock();
//
//    public void methodA() {
//        lock.lock();
//        try {
//            System.out.println(Thread.currentThread().getName() + " acquired lock in methodA");
//            Thread.sleep(3000);
//            methodB(); // same thread re-enters the lock
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            lock.unlock();
//            System.out.println(Thread.currentThread().getName() + " released lock in methodA");
//        }
//    }
//
//    public void methodB() {
//        lock.lock();
//        try {
//            System.out.println(Thread.currentThread().getName() + " re-entered lock in methodB");
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            lock.unlock();
//            System.out.println(Thread.currentThread().getName() + " released lock in methodB");
//        }
//    }
//
//    public static void main(String[] args) {
//
//        Main demo = new Main();
//
//        Runnable task = () -> {
//            demo.methodA();
//        };
//
//        Thread t1 = new Thread(task, "Thread-1");
//        Thread t2 = new Thread(task, "Thread-2");
//
//        t1.start();
//        t2.start();
//    }
//}



package org.atyeti;

public class Main {
    public static void main(String[] args) throws Exception {
        while(true){
            byte[] arr = new byte[1024 * 1024]; // 1 MB
            Thread.sleep(100);
        }
    }
}