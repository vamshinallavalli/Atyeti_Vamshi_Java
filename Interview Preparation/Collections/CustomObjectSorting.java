import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomObjectSorting {
    public static void main(String[] args) {
        String empList[]={"subani","althaf","vamshi"};

        List<String> list = Arrays.asList(empList);
        Collections.sort(list, Comparator.reverseOrder());

        System.out.println(list);
    }
}
