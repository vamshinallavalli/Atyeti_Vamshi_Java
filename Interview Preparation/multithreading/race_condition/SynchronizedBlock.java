package race_condition;

// File: SynchronizedBlockExample.java
public class SynchronizedBlock {
    public static void main(String[] args) throws InterruptedException {
        BankAccount2 account = new BankAccount2();

        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(400);
            }
        };

        Thread t1 = new Thread(task, "Husband");
        Thread t2 = new Thread(task, "Wife");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}

class BankAccount2 {
    private int balance = 1000;
    private final Object lock = new Object();  // explicit lock object

    public void withdraw(int amount) {
        String name = Thread.currentThread().getName();

        synchronized (lock) {  // Only one thread can enter this block at a time
            if (balance >= amount) {
                System.out.println(name + " withdrawing " + amount);
                try { Thread.sleep(200); } catch (Exception e) {} // simulate delay
                balance -= amount;
                System.out.println(name + " done. Balance = " + balance);
            } else {
                System.out.println(name + " → Insufficient funds!");
            }
        }

        // Code outside synchronized block can run in parallel
        System.out.println(name + " is doing something else...");
    }

    public int getBalance() { return balance; }
}
