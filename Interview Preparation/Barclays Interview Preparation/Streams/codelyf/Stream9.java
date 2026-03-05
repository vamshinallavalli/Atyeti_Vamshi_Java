// Find the longest word in a list

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Stream9 {
    public static void main(String[] args) {
        List<String> words= Arrays.asList("cat","elephant","dog","giraffe","zebra");

        String longestWord=words.stream().max(Comparator.comparing(String::length)).orElse(null);

        System.out.println(longestWord);
    }
}
