// Remove Duplicates without Distinct

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Stream1 {

    public static void main(String[] args) {
        List<Integer> duplicateElements= Arrays.asList(1,2,3,2,4,3,5,1);

      //  List<Integer> uniqueList=duplicateElements.stream().distinct().collect(Collectors.toList());

        HashSet<Integer> seen=new HashSet<>();

        List<Integer> uniqueElements=duplicateElements.stream().filter(seen::add).toList();

        System.out.println(uniqueElements);
    }
}
