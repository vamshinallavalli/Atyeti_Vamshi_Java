// Given a list of strings, find the longest string using Java streams

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Stream5_2 {
    public static void main(String[] args) {
        List<String> strings= Arrays.asList("apple","banana","orange","grape","kiwi");

       // String longestString=strings.stream().max(Comparator.naturalOrder()).orElse("0");

        String longestString=strings.stream().max(Comparator.comparingInt(String::length)).orElse("0");


        System.out.println(longestString);
    }
}
