package Scenario_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 E-commerce Cart Total Calculation (For loop).
Given a list of cart items with price and quantity, loop through and:
 Calculate total bill
 Apply a 10% discount if total exceeds 5000
 Stop processing further items if total exceeds 10,000 (simulate “max cart limit”)
Hint:
 Loops through each CartItem and adds price × quantity to the total.
 Stops the loop early if total > 10,000.
 Applies a 10% discount if the total is above 5,000
 */
public class CardBilling {
    public static void main(String[] args) {
        Items item1=new Items(2567,2);
        Items item2=new Items(765,1);
        Items item3=new Items(60,8);
        Items item4=new Items(875,1);
        Items item5=new Items(600,3);

        List<Items> list=new ArrayList<>(Arrays.asList(item1,item2,item3,item4,item5));

        double total=0;

        for(Items item:list){
            double itemCost = item.getPrice() * item.getQuantity();
            total += itemCost;

            if(total>10000){
                System.out.println("Maximum Cart");
                return;
            }
        }


        if(total>5000){
            System.out.println("Your Total bill is : "+(total-(total*0.10)));
        }else{
            System.out.println("Your Total bill is : "+(total));

        }

    }
}
