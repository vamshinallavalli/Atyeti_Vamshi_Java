package toMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//  toMap(keyMapper, valueMapper)	Basic map with no duplicate keys

public class ToMap {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6);

        Map<Integer,Integer> map=list.stream().collect(Collectors.toMap(s->s, s->s*2));

        System.out.println(map);
    }
}
