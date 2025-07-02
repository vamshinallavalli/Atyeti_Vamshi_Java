import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        int arr[] = {30, 20, 10};
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }
}