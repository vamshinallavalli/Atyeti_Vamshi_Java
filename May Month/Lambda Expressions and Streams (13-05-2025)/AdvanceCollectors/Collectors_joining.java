package AdvanceCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//  Concatenates strings with optional delimiter, prefix, and suffix.
public class Collectors_joining {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Shyam", "Mohan");

        String result = names.stream()
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(result);
// Output: [Ram, Shyam, Mohan]

    }
}
