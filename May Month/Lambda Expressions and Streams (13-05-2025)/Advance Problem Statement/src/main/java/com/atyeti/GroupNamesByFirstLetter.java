package com.atyeti;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupNamesByFirstLetter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Ankit", "Bala");

        Map<Character,List<String>> map=names.stream()
                .collect(Collectors.groupingBy(s->s.charAt(0)));

        System.out.println(map);
    }
}