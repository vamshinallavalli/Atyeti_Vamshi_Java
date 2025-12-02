package deadlock.coffmanConditions;

public class DeadlockWithCoffmanConditions {
    public static void main(String[] args) {

        // Two resources (like two phones, two printers, etc.)
        final Object lock1 = new Object();  // Resource A
        final Object lock2 = new Object();  // Resource B

        // Thread-1 : grabs lock1 first → then wants lock2
        Thread person1 = new Thread(() -> {
            synchronized (lock1) {                              // 1. MUTUAL EXCLUSION + HOLD
                System.out.println("Person-1: Holding Pen");    // Holding lock1 (the Pen)

                try { Thread.sleep(500); } catch (Exception e) {}

                System.out.println("Person-1: Waiting for Book");

                synchronized (lock2) {                          // Wants lock2 (the Book)
                    System.out.println("Person-1: Got both - writing...");
                }
            }
        }, "Person-1");

        // Thread-2 : grabs lock2 first → then wants lock1
        Thread person2 = new Thread(() -> {
            synchronized (lock2) {                              // 1. MUTUAL EXCLUSION + HOLD
                System.out.println("Person-2: Holding Book");   // Holding lock2 (the Book)

                try { Thread.sleep(500); } catch (Exception e) {}

                System.out.println("Person-2: Waiting for Pen");

                synchronized (lock1) {                          // Wants lock1 (the Pen)
                    System.out.println("Person-2: Got both - writing...");
                }
            }
        }, "Person-2");

        person1.start();
        person2.start();
    }
}


/*

Coffman Conditions Summary:

1. Mutual Exclusion      : YES → synchronized(lock1) and synchronized(lock2)
2. Hold and Wait         : YES → Each thread holds one lock and waits for the other
3. No Preemption         : YES → Java never forcibly releases a lock from a thread
4. Circular Wait         : YES → Person-1 waits for lock2 (held by Person-2)
                            Person-2 waits for lock1 (held by Person-1) → perfect circle

All 4 conditions satisfied simultaneously → DEADLOCK GUARANTEED

 */