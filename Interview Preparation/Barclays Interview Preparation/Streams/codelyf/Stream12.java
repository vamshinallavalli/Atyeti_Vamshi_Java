import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Stream12 {
    public static void main(String[] args) {
        List<Integer> listOfIntegers= Arrays.asList(71,18,42,21,67,32,95,14,56,87);

        // Get top 3 elements from the list

        List<Integer> top3= listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).toList();

        System.out.println(top3);


        // Get 3rd highest element

        // List<Integer> thirdHighest=listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).skip(2).toList();

        int thirdHighest=listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(-1);


        System.out.println(thirdHighest);
    }
}
