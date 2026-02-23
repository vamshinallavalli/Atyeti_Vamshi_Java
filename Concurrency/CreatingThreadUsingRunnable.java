
class MyTask implements Runnable {
    public void run() {
        System.out.println("Running thread: " + Thread.currentThread().getName());
    }
}

public class CreatingThreadUsingRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask());
        t1.start();
    }
}
