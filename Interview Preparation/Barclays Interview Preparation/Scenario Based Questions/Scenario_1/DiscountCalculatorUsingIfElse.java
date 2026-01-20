package Scenario_1;

/*
If – Else Conditions or Switch.

If a customer is a "Premium" member and purchases more than 5 items, give 20% discount. If
not premium but buys more than 10 items, give 10% discount. Otherwise, no discount.

 */

import java.util.Scanner;

public class DiscountCalculatorUsingIfElse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome To Big Bazaar Basket :)");
        System.out.println("Select Membership:");
        System.out.println("1. Premium Member");
        System.out.println("2. Non-Premium Member");

        int option = sc.nextInt();

        System.out.println("Enter Number of Items:");
        int items = sc.nextInt();

        int bill = items * 100;
        double finalBill = bill;

        if (option == 1 && items > 5) {
            finalBill = bill - (bill * 0.20);
        }
        else if (option == 2 && items > 10) {
            finalBill = bill - (bill * 0.10);
        }

        System.out.println("Your final bill is: " + finalBill);

        sc.close();
    }
}
