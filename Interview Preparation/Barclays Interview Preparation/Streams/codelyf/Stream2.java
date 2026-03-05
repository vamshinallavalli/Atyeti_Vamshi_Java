// get duplicates

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Stream2 {
    public static void main(String[] args) {
        List<Integer> duplicateNumbers= Arrays.asList(1,2,3,2,4,3,5,1);

        HashSet<Integer> seen=new HashSet<>();

        List<Integer> duplicates=duplicateNumbers.stream().filter(s->
                !seen.add(s) ).collect(Collectors.toList());


        System.out.println(duplicates);
    }
}
