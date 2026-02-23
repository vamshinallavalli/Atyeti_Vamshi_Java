package testing;

import java.util.Arrays;

public class SumOfAllEven {
    public static void main(String[] args) {
        int arr[]={4,2,4,5,6,7,1,3};

        long sum= Arrays.stream(arr).boxed().filter(s->s%2==0).reduce(0,Integer::sum);

        System.out.println(sum);
    }
}
