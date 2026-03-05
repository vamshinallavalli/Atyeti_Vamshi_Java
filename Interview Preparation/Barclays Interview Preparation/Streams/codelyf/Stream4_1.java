// Given a List of Strings, sort them according to increasing order of their length

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Stream4_1 {
    public static void main(String[] args) {
        List<String> listOfStrings= Arrays.asList("Java","Python","C#","HTML","Kotlin","C++","COBOL","C");

        List<String> increasingOrderOfStrings=listOfStrings.stream().sorted(Comparator.comparing(String::length)).toList();

        System.out.println(increasingOrderOfStrings);
    }
}
