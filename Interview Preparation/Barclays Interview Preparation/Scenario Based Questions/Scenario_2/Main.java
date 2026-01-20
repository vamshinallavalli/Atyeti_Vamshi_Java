package Scenario_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AtmOperations atm = new AtmOperations();

        // 🔐 PIN Validation
        int attempts = 3;
        final int PIN = 1234;

        while (attempts > 0) {
            System.out.print("Enter ATM PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == PIN) {
                System.out.println("Login successful!\n");
                break;
            } else {
                attempts--;
                System.out.println("Incorrect PIN. Attempts left: " + attempts);
            }

            if (attempts == 0) {
                System.out.println("ATM blocked. Try later.");
                return;
            }
        }

        // 🏧 ATM Menu
        while (true) {
            System.out.println("\nWelcome to ATM Services :)");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    atm.withdraw(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    atm.deposit(sc.nextDouble());
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using ATM services. Have a nice day!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}