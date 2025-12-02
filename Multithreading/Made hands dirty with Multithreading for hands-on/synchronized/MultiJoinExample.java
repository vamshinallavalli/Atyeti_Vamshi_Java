public class MultiJoinExample {
    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> System.out.println("T1 Work"));
        Thread t2 = new Thread(() -> System.out.println("T2 Work"));
        Thread t3 = new Thread(() -> System.out.println("T3 Work"));

        t1.start();
        t1.join(); // Wait for T1

        t2.start();
        t2.join(); // Wait for T2

        t3.start();
        t3.join(); // Wait for T3

        System.out.println("All tasks done!");
    }
}