package Scenario_5;

import java.util.Scanner;

/*
 Password Strength Checker.
Given a string password, loop through characters and:
 Count uppercase, lowercase, digits, and special characters
 If all categories are present and length ≥ 8, print “Strong password” else “Weak password
Hint:
 Loops through each character.
 Uses Character methods for uppercase, lowercase, and digit detection.
 Treats anything else as a special character.
 Strength check: at least one from each category and length ≥ 8.
 */
public class PasswordChecker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new Password : ");
        String password1=sc.nextLine();
        System.out.println("Re-enter new Password : ");
        String password2=sc.nextLine();

        if(!password1.equals(password2))
            System.out.println("Password Doesn't Match!");

        char[] pass=password1.toCharArray();
        int count=0,digit=0,lower=0,upper=0,special=0;

        for(char arr:pass){
            if(Character.isDigit(arr))
                digit++;
            if(Character.isUpperCase(arr))
                upper++;
            if(Character.isLowerCase(arr))
                lower++;
            else
                special++;
        }

        count=digit+upper+lower+special;

        if(digit>0 && upper>0 && lower>0 && special>0 && count>=8){
                System.out.println("Strong Password!");
        }else{
            System.out.println("Weak Password!");

            System.out.println("Follow Rules: \n * Password must and should contain 1 or more of below characters \n - uppercase \n -lowercase \n -digits \n -special ");

        }

    }


}
