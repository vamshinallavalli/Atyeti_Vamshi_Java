public class JoinMethod {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("Child thread");
        });

        t.start();
        t.join();
        System.out.println("Main thread");
    }
}

