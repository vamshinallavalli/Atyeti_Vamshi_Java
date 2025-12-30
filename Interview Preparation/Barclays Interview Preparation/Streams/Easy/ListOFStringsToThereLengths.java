package Easy;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOFStringsToThereLengths {
    public static void main(String[] args) {
        String str[]={"vamshi","shoheb","althaf","subani","revathi"};

        //Map<String,Integer> map= Arrays.stream(str).collect(Collectors.groupingBy((s1,s2)->s1, s2.length());

        Map<String,Integer> map= Arrays.stream(str).collect(Collectors.toMap(s->s,String::length));

        System.out.println(map);
    }
}
