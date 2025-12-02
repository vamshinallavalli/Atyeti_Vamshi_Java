package basic;

public class ThreadMethods extends Thread {

    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");

        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);

            if (i == 3) {
                System.out.println(Thread.currentThread().getName() + " yielding...");
                Thread.yield();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted!");
                return;
            }
        }

        System.out.println(Thread.currentThread().getName() + " finished");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMethods t1 = new ThreadMethods();
        ThreadMethods t2 = new ThreadMethods();

        System.out.println("Main thread: Starting t1 and t2");

        t1.start();
        t2.start();

        System.out.println("Is t1 alive? " + t1.isAlive());

        t1.join();
        System.out.println("t1 has finished. Main resumes.");

        Thread.sleep(1000);
        if (t2.isAlive()) {
            System.out.println("Main thread: Interrupting t2");
            t2.interrupt();
        }

        t2.join();
        System.out.println("t2 has finished. Main ends.");
    }
}
