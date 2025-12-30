package Intermediate;

import java.util.*;

public class SecondHighestNumber {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9};

        int max = Arrays.stream(arr).max().getAsInt();

        int secondHighest =
                Arrays.stream(arr)
                        .filter(n -> n < max)
                        .max().getAsInt();

        System.out.println("Second Highest: " + secondHighest);
    }
}
