package Scenario_2;

public class AtmOperations {

    private double accountBalance = 10000;   // initial balance
    private static final double MIN_BALANCE = 500;

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        accountBalance += amount;
        System.out.println(amount + " deposited successfully!");
        printBalance();
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }

        if (accountBalance - amount >= MIN_BALANCE) {
            accountBalance -= amount;
            System.out.println(amount + " withdrawn successfully!");
            printBalance();
        } else {
            System.out.println("Insufficient funds! Minimum balance must be " + MIN_BALANCE);
        }
    }

    public void checkBalance() {
        printBalance();
    }

    private void printBalance() {
        System.out.println("Current Balance: " + accountBalance);
    }
}