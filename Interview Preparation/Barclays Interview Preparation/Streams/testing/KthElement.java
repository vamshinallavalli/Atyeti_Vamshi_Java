package testing;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KthElement {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 3};
        int k = 2;

        Map<Integer, Long> freqMap =
                Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ));


        freqMap.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).skip(k - 1).findFirst()

        //   Optional<Map.Entry<Integer, Long>> result = freqMap.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).skip(k - 1).findFirst();


        result.ifPresent(e ->
                System.out.println(
                        "Element: " + e.getKey() + ", Frequency: " + e.getValue()
                )
        );


    }
}
