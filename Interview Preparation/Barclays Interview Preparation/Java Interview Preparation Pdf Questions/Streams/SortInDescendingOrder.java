package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortInDescendingOrder {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 11, 1, 3, 5, 6, 5);

        List<Integer> list1 = list.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list1);


    }
}
