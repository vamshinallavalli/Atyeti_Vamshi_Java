package InterviewReady.Level_1;

import java.util.List;
import java.util.stream.Collectors;

public class StartingWithAFromListOfStrings {

    static List<String> list= List.of("Vamshi", "Arjun","Althaf","Shoheb","Subani");

    public static List<String> stringsStartWithA(){
        List<String> str= list.stream().filter(s->s.charAt(0)=='A').toList();

        return str;
    }
}
