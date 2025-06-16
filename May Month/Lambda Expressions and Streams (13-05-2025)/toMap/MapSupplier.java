package toMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

// toMap(keyMapper, valueMapper, mergeFunction, mapSupplier)	Also defines which Map type to use

public class MapSupplier {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apricot");

        Map<Integer, String> map = list.stream().collect(Collectors.toMap(
                String::length,                           // Key: word length
                word -> word,                             // Value: word itself
                (existing, replacement) -> existing,      // Handle duplicates
                TreeMap::new                              // Use TreeMap instead of HashMap
        ));

        System.out.println(map); // Output: {5=apple, 6=banana, 7=apricot}
    }
}
