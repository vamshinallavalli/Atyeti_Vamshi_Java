package Easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListWithDistinct {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,4,6,1,2,5,6,6,6,6,9};

        List<Integer> list=Arrays.stream(arr).boxed().distinct().collect(Collectors.toList());

        System.out.println(list);
    }
}
