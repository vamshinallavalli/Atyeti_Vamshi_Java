package Easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringsStartWithS {
    public static void main(String[] args) {
        String arr[]={"Ajay","Vamshi","Abdul","Sai","Vijay"};

        List<String> list= Arrays.stream(arr).filter(s->s.startsWith("A")).collect(Collectors.toList());

        System.out.println(list);
    }
}
