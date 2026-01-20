package Scenario_1;


/*
If – Else Conditions or Switch.

If a customer is a "Premium" member and purchases more than 5 items, give 20% discount. If
not premium but buys more than 10 items, give 10% discount. Otherwise, no discount.

 */

import java.util.Scanner;

public class DiscountCalculatorUsingSwitch {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Welcome to Big Bazaar Basket: ");
        System.out.println("Enter your option: ");
        System.out.println("1. Premium");
        System.out.println("2. Non-Premium"+"\n"+"Enter Your Option: ");

        int option=sc.nextInt();

        System.out.println("Enter number of items: ");
        int items=sc.nextInt();

        int bill=items*100;

        double finalBill=bill;

        switch (option){
            case 1: if(items>5){
                finalBill=bill-(bill*0.20);
            }
            break;

            case 2: if(items>10){
                finalBill=bill-(bill*0.10);
            }
            break;

            default:
            System.out.println("Final Bill: "+finalBill);
        }

        System.out.println("Final Bill After Discount: "+finalBill);



    }
}
