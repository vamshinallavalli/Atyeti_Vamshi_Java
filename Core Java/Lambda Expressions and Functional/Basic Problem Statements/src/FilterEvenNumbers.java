import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class FilterEvenNumbers {

    public static void filterEven() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> evenOrOdd = s -> s % 2 == 0;

        List<Integer> newList = list.stream().filter(evenOrOdd).toList();

        System.out.println(newList);
    }

}