package race_condition;

// File: SynchronizedMethodExample.java
public class SynchronizedKeyword {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread mom = new Thread(() -> {
            for (int i = 0; i < 5; i++) account.withdraw(200);
        }, "Mom");

        Thread dad = new Thread(() -> {
            for (int i = 0; i < 5; i++) account.withdraw(200);
        }, "Dad");

        mom.start();
        dad.start();

        mom.join();
        dad.join();

        System.out.println("Final balance: " + account.getBalance());
        // Expected: 0 (or positive), never negative!
    }
}

class BankAccount {
    private int balance = 1000;

    // synchronized method → automatic locking on 'this'
    public synchronized void withdraw(int amount) {
        String name = Thread.currentThread().getName();
        if (balance >= amount) {
            System.out.println(name + " is withdrawing " + amount);
            balance -= amount;
            System.out.println(name + " completed. Balance = " + balance);
        } else {
            System.out.println(name + " tried to withdraw " + amount + " but not enough money!");
        }
    }

    public int getBalance() {
        return balance;
    }
}