package com.atyeti;

public class SynchronizedBlock {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.get());
    }
}

class Count {
    private int value = 0;

    public void increment() {
        synchronized (this) {
            value++;
        }
    }

    public int get() {
        return value;
    }
}
