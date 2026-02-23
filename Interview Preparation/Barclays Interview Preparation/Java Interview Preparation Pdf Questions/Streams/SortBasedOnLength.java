package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortBasedOnLength {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL",
                "C");

        List<String> list = listOfStrings.stream().sorted(Comparator.comparing(String::length)).toList();

        System.out.println(list);
    }
}
