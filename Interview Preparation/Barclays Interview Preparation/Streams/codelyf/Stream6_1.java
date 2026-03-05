import java.util.Arrays;
import java.util.List;

// Check all numbers even or not
public class Stream6_1 {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(2,4,6,8,10);

        boolean even= numbers.stream().allMatch(s->s%2==0);

        System.out.println(even);
    }
}
