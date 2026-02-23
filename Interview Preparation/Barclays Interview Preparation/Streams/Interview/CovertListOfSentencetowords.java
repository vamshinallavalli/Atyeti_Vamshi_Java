package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CovertListOfSentencetowords {
    public static void main(String[] args) {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool"
        );


       // List<String> list=sentences.stream().flatMap(s-> Arrays.stream(s.split(" ")).toList();

        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());

        System.out.println(words);

    }
}
