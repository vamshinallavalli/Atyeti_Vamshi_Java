import java.util.concurrent.locks.ReentrantLock;

class Counter2 {
    int count = 0;
    ReentrantLock lock = new ReentrantLock(true);

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            count++;

        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) throws Exception {

        Counter2 counter = new Counter2();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    counter.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.count);
    }
}




/*
Deadlock avoidance strategies

Timeout-based locking

Cancellation logic

Responsive server applications
















AQS AbstractQueuedSynchronized

When a thread tries to acquire a lock and fails, it is:

Put into a queue

Parked (blocked)

Waits until the lock becomes available

That queue is called the AQS Wait Queue.
----------------------------------------------------------

AQS handles:

Thread queue

Blocking (park/unpark)

CAS operations

Fairness
----------------------------------------------

Who Uses It?

These classes extend AQS internally:

🔐 ReentrantLock

📖 ReentrantReadWriteLock

🚦 Semaphore

⏳ CountDownLatch

🎯 FutureTask

These classes extend AQS and implement:

protected boolean tryAcquire(int arg)
protected boolean tryRelease(int arg)

-----------------------------------------
if (!tryAcquire()) {
    enqueue(node);
    while (!tryAcquire()) {
        LockSupport.park();
    }
}












Imagine:

Thread A holds lock for 5 minutes

Thread B is waiting

User cancels operation

You want Thread B to stop waiting

With synchronized →  impossible
With lockInterruptibly() →  possible


 */