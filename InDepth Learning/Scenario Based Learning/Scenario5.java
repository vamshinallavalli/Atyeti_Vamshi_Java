/*
 Java Scenario 5: Password Strength Checker.
Given a string password, loop through characters and:
 Count uppercase, lowercase, digits, and special characters
 If all categories are present and length ≥ 8, print “Strong password” else “Weak password
Hint:
 Loops through each character.
 Uses Character methods for uppercase, lowercase, and digit detection.
 Treats anything else as a special character.
 Strength check: at least one from each category and length ≥ 8.
 */

import java.util.Scanner;

public class Scenario5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Password: ");
        String password=sc.next();

        int lower=0,upper=0,digit=0,special=0;

        for(char c:password.toCharArray()){
            if(Character.isDigit(c))
                digit++;
            else if(Character.isUpperCase(c))
                upper++;
            else if(Character.isLowerCase(c))
                lower++;
            else
                special++;
        }


        if(password.length()>=8 && upper>0 && lower>0 && digit>0 && special>0)
            System.out.println("Strong Password");
        else
            System.out.println("Week Password");
    }
}
