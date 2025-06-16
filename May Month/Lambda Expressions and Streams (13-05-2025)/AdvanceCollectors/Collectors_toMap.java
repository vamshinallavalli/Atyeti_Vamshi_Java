package AdvanceCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors_toMap {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tom", "Tim", "Tim");

        Map<String, Integer> map = names.stream()
                .collect(Collectors.toMap(
                        name -> name,
                        String::length,
                        (v1, v2) -> v1  // if duplicate, keep the first
                ));

        System.out.println(map);

        // Output: {Tom=3, Tim=3}

    }
}
