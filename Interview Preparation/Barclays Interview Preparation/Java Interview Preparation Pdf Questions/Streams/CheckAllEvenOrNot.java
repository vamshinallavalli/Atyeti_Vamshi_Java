package Streams;

import java.util.Arrays;
import java.util.List;

public class CheckAllEvenOrNot {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);

        boolean b = numbers.stream().allMatch(s -> s % 2 == 0);

        System.out.println("Is All are Even : "+b);
    }
}
