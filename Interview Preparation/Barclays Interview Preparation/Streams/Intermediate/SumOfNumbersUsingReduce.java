package Intermediate;

import java.util.Arrays;

public class SumOfNumbersUsingReduce {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};

        System.out.println("Sum : "+Arrays.stream(arr).reduce(Integer::sum).getAsInt());
    }
}
