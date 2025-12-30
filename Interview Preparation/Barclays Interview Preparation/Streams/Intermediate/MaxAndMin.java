package Intermediate;

import java.util.Arrays;

public class MaxAndMin {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};

        System.out.println("Max: "+Arrays.stream(arr).max().getAsInt());
        System.out.println("Min: "+Arrays.stream(arr).min().getAsInt());

    }
}
