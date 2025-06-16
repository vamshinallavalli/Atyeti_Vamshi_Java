package toMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// toMap(keyMapper, valueMapper, mergeFunction)	Handles key collisions

public class MergeFunction {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apricot");

        Map<Character, String> map = list.stream().collect(Collectors.toMap(
                word -> word.charAt(0),                   // Key: first character
                word -> word,                             // Value: the word itself
                (existing, replacement) -> existing       // Merge function
        ));

        System.out.println(map); // Output: {a=apple, b=banana}
    }
}
