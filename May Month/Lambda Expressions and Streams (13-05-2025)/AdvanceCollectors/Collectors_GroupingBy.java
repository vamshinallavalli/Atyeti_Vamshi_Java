package AdvanceCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Used to group elements by a classifier function.

public class Collectors_GroupingBy {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Map<String, List<Integer>> result = list.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));

        System.out.println(result);
// Output: {Even=[2, 4], Odd=[1, 3, 5]}

    }
}
