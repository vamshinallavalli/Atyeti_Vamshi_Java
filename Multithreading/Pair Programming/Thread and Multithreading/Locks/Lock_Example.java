package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// More flexible than synchronized. Supports tryLock(), fairness, multiple conditions.

public class Lock_Example {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        lock.lock();
        try {
            System.out.println("Locked Code");
        } finally {
            lock.unlock();
        }

//        ReadWriteLock rw = new ReentrantReadWriteLock();
//        rw.readLock().lock();
//        System.out.println("Reading...");
//        rw.readLock().unlock();



    }
}
