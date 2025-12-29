package InterviewReady.Level_1;

import java.util.Arrays;
import java.util.List;

public class ListOfStringsToUpperCase {
    static List<String> str=List.of("vamshi","althaf","subani");

    public static List<String> stringToUpperCaseUsingMap(){
        return str.stream().map(s->s.toUpperCase()).toList();
    }
}
