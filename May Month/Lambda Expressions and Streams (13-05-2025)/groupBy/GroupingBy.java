import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6);

        Map<String,List<Integer>> map=list.stream().collect(Collectors.groupingBy(s->(s%2==0)?"Even":"Odd"));
        System.out.println(map);
    }
}
