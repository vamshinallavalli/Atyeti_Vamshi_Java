import java.util.Scanner;
/*
 Java Scenario 1:  If – Else Conditions or Switch.
If a customer is a "Premium" member and purchases more than 5 items, give 20%
discount. If not premium but buys more than 10 items, give 10% discount. Otherwise, no
discount.
 */

public class Scenario1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of Items: ");
        int items=sc.nextInt();

        System.out.println("Are you a Premium member: (yes/no)");
        String choice=sc.next();

        if(choice.equals("yes")){
            if(items>5)
                System.out.println("Discount got 20%");
            else
                System.out.println("no discount");
        }
        else if(choice.equals("no")){
            if(items>10)
                System.out.println("Discount got 10%");
            else
                System.out.println("no discount");
        }

    }
}
