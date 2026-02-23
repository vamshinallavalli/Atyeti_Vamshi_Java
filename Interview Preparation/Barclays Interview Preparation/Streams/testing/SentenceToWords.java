package testing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class SentenceToWords {
    public static void main(String[] args) {
        String sentence="India is my country all indians are my brother and sister";


        Stream.of(sentence).flatMap(s-> Arrays.stream(s.split("\\s+"))).forEach(System.out::println);
















        //sentence.chars().mapToObj(s->(char)s).flatMap(s->s.toString().split(" "))

   //     Stream.of(sentence).flatMap(s->Arrays.stream(s.split("\\s+")))
//                .forEach(System.out::println);
    }
}
