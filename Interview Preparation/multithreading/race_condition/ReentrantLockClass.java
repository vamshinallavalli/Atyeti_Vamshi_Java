package race_condition;

// File: ReentrantLockExample.java
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockClass {
    public static void main(String[] args) throws InterruptedException {
        BankAccount3 account = new BankAccount3();

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 4; i++) {
                account.withdraw(300);
                try { Thread.sleep(100); } catch (Exception e) {}
            }
        };

        Thread child1 = new Thread(withdrawTask, "Child-1");
        Thread child2 = new Thread(withdrawTask, "Child-2");

        child1.start();
        child2.start();
        child1.join();
        child2.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}

class BankAccount3 {
    private int balance = 1000;
    private final ReentrantLock lock = new ReentrantLock();

    public void withdraw(int amount) {
        String name = Thread.currentThread().getName();

        if (lock.tryLock()) {  // Non-blocking attempt (you can also use lock.lock())
            try {
                if (balance >= amount) {
                    System.out.println(name + " withdrawing " + amount);
                    balance -= amount;
                    System.out.println(name + " completed → Balance = " + balance);
                } else {
                    System.out.println(name + " → Not enough money!");
                }
            } finally {
                lock.unlock();  // Always unlock in finally!
            }
        } else {
            System.out.println(name + " couldn't get the lock, skipping...");
        }
    }

    public int getBalance() { return balance; }
}
