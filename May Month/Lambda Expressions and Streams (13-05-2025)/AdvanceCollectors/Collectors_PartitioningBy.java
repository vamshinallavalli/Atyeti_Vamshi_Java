package AdvanceCollectors;


// Splits the stream into two groups: true and false based on a predicate.

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors_PartitioningBy {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> result = list.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(result);
// Output: {false=[1, 3, 5], true=[2, 4]}

    }
}
