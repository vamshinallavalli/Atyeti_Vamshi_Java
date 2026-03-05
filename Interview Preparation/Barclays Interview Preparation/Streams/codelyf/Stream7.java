// Numbers starting with 1

import java.util.Arrays;
import java.util.List;

public class Stream7 {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(10,12,20,null,19,30);

        List<Integer> numberStartWith1=numbers.stream().filter(s->String.valueOf(s).startsWith("1")).toList();

        System.out.println(numberStartWith1);
    }
}
