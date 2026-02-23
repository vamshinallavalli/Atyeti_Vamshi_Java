package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringUsingStreams {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange","grape", "kiwi");

       // String s = strings.stream().max(Comparator.comparing(String::length)).orElse(null);

        String s = strings.stream().max((a,b)->a.length()-b.length()).orElse(null);

        System.out.println("Max Length String is : "+s);
    }
}
