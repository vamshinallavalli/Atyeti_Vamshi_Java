package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> arr= (ArrayList<Integer>) Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> list=arr.stream().filter(s->s%2==0).collect(Collectors.toList());

        System.out.println(list);

    }
}
