

import java.util.concurrent.CountDownLatch;

class Foo {
    CountDownLatch firstDone = new CountDownLatch(1);
    CountDownLatch secondDone = new CountDownLatch(1);


    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run(); // prints "first"
        firstDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.await();
        printSecond.run(); // prints "second"
        secondDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondDone.await();
        printThird.run(); // prints "third"
    }
}

class PrintInOrder {

    public static void main(String[] args) {

        Foo foo = new Foo();

        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start threads in random order (just for demonstration)
        t3.start();
        t1.start();
        t2.start();


    }
}
