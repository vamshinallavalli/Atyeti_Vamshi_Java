package AdvanceCollectors;


// Used inside groupingBy or collectingAndThen to map grouped elements.

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors_Mapping {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "ant", "bat", "ball");

        Map<Integer, List<Character>> map = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(word -> word.charAt(0), Collectors.toList())
                ));

        System.out.println(map);
// Output: {3=[a, b], 4=[b], 5=[a]}

    }
}
