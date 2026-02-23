package Interview;

import java.util.Arrays;
import java.util.List;

public class EvenNumber {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 10, 7, 4, 9, 12, 6);

        List<Integer> list=nums.stream().filter(s->s%2==0).toList();

        System.out.println(list);
    }
}
