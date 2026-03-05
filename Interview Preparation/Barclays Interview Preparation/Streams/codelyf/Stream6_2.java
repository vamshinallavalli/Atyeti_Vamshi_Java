// Check if Any String Starts with 'A'

import java.util.Arrays;
import java.util.List;

public class Stream6_2 {
    public static void main(String[] args) {
        List<String> nameList= Arrays.asList("Apple","Cat","Andrew");

        boolean isThere=nameList.stream().anyMatch(s->s.startsWith("A"));

        System.out.println(isThere);
    }
}
