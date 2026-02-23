package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Duplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6);

        List<Integer> arr=list.stream().collect(Collectors.groupingBy(n->n,Collectors.counting())).entrySet().stream().filter(s->s.getValue()>1).map(Map.Entry::getKey).toList();

        System.out.println(arr);

    }
}
