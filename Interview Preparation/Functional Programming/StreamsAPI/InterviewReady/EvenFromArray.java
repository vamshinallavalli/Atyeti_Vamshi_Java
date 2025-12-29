package InterviewReady;

import java.util.Arrays;
import java.util.List;

public class EvenFromArray {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};

        List<Integer> list= Arrays.stream(arr).boxed().filter(s->s%2==0).toList();

        System.out.println(list);
    }
}
