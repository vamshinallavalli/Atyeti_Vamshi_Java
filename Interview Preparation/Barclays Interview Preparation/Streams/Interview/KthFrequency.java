package Interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KthFrequency {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4};
        int k = 2;


        Map<Integer,Long> map= Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(map);

       // map.entrySet().stream().sorted(Map.Entry.<Integer,Long>comparingByValue().reversed()).sk

        List<Map.Entry<Integer,Long>> list=new ArrayList<>(map.entrySet());

        list.sort((a,b)->b.getValue().compareTo(a.getValue()));

        System.out.println(list);
    }
}
