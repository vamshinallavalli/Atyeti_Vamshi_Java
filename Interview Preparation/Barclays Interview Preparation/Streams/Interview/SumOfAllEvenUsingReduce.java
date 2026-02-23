package Interview;

import java.util.List;

public class SumOfAllEvenUsingReduce {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);


        int sum=numbers.stream().filter(s->s%2==0).reduce(0,Integer::sum);

        System.out.println(sum);
    }
}
