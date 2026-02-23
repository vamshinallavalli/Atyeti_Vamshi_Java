package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxNumberInList {
    public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 4, 41, 4);

        Integer i = numbers.stream().max(Comparator.naturalOrder()).orElse(0);

        System.out.println("Max : "+i);
        }
}
