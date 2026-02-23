package Streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GetDuplicates {
    public static void main(String[] args) {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5, 1);

        HashSet<Integer> set=new HashSet<>();

        List<Integer> list = duplicateNumbers.stream().filter(i -> !set.add(i)).toList();

        System.out.println(list);

    }
}
