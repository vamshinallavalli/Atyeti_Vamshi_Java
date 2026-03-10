import java.util.Arrays;
import java.util.List;

    /*
    Java Scenario 4: E-commerce Cart Total Calculation (For loop).
Given a list of cart items with price and quantity, loop through and:
 Calculate total bill
 Apply a 10% discount if total exceeds 5000
 Stop processing further items if total exceeds 10,000 (simulate “max cart limit”)
Hint:
 Loops through each CartItem and adds price × quantity to the total.
 Stops the loop early if total > 10,000.
 Applies a 10% discount if the total is above 5,000
     */
 import java.util.Arrays;
import java.util.List;

    public class Scenario4 {

        public static void main(String[] args) {

            List<CartItem> cart = Arrays.asList(
                    new CartItem("Laptop", 40000, 1),
                    new CartItem("Mouse", 500, 2),
                    new CartItem("Keyboard", 1500, 1),
                    new CartItem("Monitor", 12000, 1)
            );

            double total = 0;

            for (CartItem item : cart) {

                double itemCost = item.price * item.quantity;
                total += itemCost;

                if (total > 10000) {
                    System.out.println("Max Cart Limit reached...");
                    break;
                }
            }

            if (total > 5000) {
                total = total - (total * 0.10); // 10% discount
                System.out.println("10% Discount applied.");
            }

            System.out.println("Final total bill: " + total);
        }
    }

    class CartItem {

        String name;
        double price;
        int quantity;

        CartItem(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }