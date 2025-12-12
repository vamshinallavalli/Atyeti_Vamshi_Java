import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfCharacters {
    public static void main(String[] args) {
        String name="Vamshi";

        Map<Character,Long> frequencies=name.chars().mapToObj(s->(char)s).collect(Collectors.groupingBy(c->c,Collectors.counting()));

        System.out.println(frequencies);
    }
}
