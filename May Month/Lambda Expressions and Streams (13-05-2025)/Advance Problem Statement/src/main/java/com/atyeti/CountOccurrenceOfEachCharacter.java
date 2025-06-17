package com.atyeti;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurrenceOfEachCharacter {
    public static void main(String[] args) {
        String input = "banana";

        Map<Character,Long> map=input.chars().mapToObj(s->(char)s)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(map);

    }
}
