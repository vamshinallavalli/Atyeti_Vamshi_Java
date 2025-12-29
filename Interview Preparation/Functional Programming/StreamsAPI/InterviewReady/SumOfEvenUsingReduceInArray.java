package InterviewReady;

import java.util.Arrays;

public class SumOfEvenUsingReduceInArray {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};

        long sum= Arrays.stream(arr).boxed().filter(s->s%2==0).reduce(0 ,Integer::sum);

        System.out.println(sum);
    }
}
