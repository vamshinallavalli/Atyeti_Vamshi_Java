package Easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AscendingAndDescendingOrder {
    public static void main(String[] args) {
        int arr[]={3,2,4,8,6,9,10};

        List<Integer> list=Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());

        System.out.println("Ascending Order: "+list);

        List<Integer> list2=Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println("Descending Order: "+list2);
    }
}
