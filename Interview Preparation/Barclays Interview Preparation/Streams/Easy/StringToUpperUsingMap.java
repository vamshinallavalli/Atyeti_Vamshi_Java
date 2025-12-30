package Easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToUpperUsingMap {
    public static void main(String[] args) {
        String arr[]={"varun","vamshi","ajay","balu"};

        List<String> list= Arrays.stream(arr).map(s->s.toUpperCase()).collect(Collectors.toList());

        System.out.println(list);
    }
}
