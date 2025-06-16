package AdvanceCollectors;

// Wraps another collector and applies a finisher function after collecting.

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Collectors_CollectingAndThen {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C");

        List<String> unmodifiable = list.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));

        System.out.println(unmodifiable);

        // Output: [A, B, C]

    }
}
