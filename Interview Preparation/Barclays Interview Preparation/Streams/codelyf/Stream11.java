// Merge two unsorted arrays into single sorted array

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream11 {
    public static void main(String[] args) {
        int[] a=new int[] {4,2,7,1};
        int[] b=new int[] {8,3,9,5};

        List<Integer> sortedAndMerged= Stream.concat(Arrays.stream(a).boxed(),Arrays.stream(b).boxed()).sorted().toList();

        System.out.println(sortedAndMerged);
    }
}
