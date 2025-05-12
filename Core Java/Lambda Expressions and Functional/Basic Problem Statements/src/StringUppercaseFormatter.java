import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class StringUppercaseFormatter {

    public static void lowerCasetoUpperCase() {
        Function<String, String> function = String::toUpperCase;

        List<String> list= Arrays.asList("apple", "banana", "cherry");

        List<String> newList=list.stream().map(function).toList();

        System.out.println(newList);
    }
}
