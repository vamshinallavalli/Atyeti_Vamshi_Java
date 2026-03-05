// Sort in descending order

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Stream3 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(11,11,1,3,5,6,5);

        List<Integer> descendingOrder=list.stream().distinct().sorted(Comparator.reverseOrder()).toList();

        System.out.println(descendingOrder);
    }
}
