// Find Palindrome Strings

import java.util.Arrays;
import java.util.List;

public class Stream8 {
    public static void main(String[] args) {
        List<String> palindromeNames= Arrays.asList("Telugu","Tamil","Malayalam");

        List<String> palindromeStrings = palindromeNames.stream().filter(s->{ return s.toLowerCase().contentEquals(new StringBuilder(s.toLowerCase()).reverse());}).toList();

        System.out.println(palindromeStrings);
    }
}
