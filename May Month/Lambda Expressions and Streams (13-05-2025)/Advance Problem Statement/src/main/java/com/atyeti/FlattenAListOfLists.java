package com.atyeti;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenAListOfLists {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d")
        );

        List<String> newList=list.stream().flatMap(List::stream).toList();

        System.out.println(newList);
    }
}
