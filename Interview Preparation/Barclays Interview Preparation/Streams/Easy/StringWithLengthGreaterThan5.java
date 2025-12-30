package Easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringWithLengthGreaterThan5 {
    public static void main(String[] args) {
        String str[]={"Vamsi","Shoheb","Althaf","Subani"};

        List<String> list= Arrays.stream(str).filter(s->s.length()>5).collect(Collectors.toList());

        System.out.println(list);
    }
}
