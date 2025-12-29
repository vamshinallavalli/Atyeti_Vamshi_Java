package InterviewReady;

import java.util.Arrays;
import java.util.List;

// convert the list of sentence into the words using flat map
public class ListOfSentenceToWords {
    public static void main(String[] args) {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are awesome",
                "FlatMap converts streams"
        );

        List<String> str=sentences.stream().flatMap(s-> Arrays.stream(s.split(" "))).toList();

        System.out.println(str);
    }
}