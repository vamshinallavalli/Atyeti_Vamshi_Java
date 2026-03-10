import java.util.Scanner;

/*
 Java Scenario 2: ATM Operations - Switch.
Write logic to handle ATM operations:
 Ask user for operation type (withdraw, deposit, check_balance).
 If withdraw, check if the balance is sufficient; if yes, deduct amount, else show “Insufficient
funds”.
 If deposit, add amount to balance.
 If check_balance, display balance.
Hint: Use a switch for operation type
 */

public class Scenario2 {
    public static void main(String[] args) {

        long balance = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nEnter your choice:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter amount to withdraw:");
                    long withdrawAmount = sc.nextLong();

                    if (balance >= withdrawAmount) {
                        balance = balance - withdrawAmount;
                        System.out.println("Withdraw successful: " + withdrawAmount);
                        System.out.println("Current Balance: " + balance);
                    } else {
                        System.out.println("Insufficient Funds!");
                    }
                    break;

                case 2:
                    System.out.println("Enter amount to deposit:");
                    long depositAmount = sc.nextLong();

                    balance = balance + depositAmount;
                    System.out.println("Amount deposited successfully.");
                    System.out.println("Current Balance: " + balance);
                    break;

                case 3:
                    System.out.println("Balance in Account: " + balance);
                    break;

                case 4:
                    System.out.println("Thank you for using ATM.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}