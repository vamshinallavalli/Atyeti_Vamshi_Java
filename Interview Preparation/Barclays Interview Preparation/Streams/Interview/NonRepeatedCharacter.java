package Interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NonRepeatedCharacter {
    public static void main(String[] args) {
        String s = "aabbcddeffg";

       Map<Character,Long> ch= s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, LinkedHashMap::new,Collectors.counting()));

        System.out.println(ch.entrySet().stream().filter(e->e.getValue()==1).map(Map.Entry::getKey).findFirst());
    }
}
