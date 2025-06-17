import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StringFilterUsingPredicate {
    public static void stringFilter(){
        List<String> list= Arrays.asList("Vamshi","Arjun","Bharat");

        Predicate<String> startsWith=s->s.startsWith("A");

        List<String> newList=list.stream().filter(startsWith).toList();

        System.out.println(newList);
    }
}
