import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.*;

public class CustomObjectSorting {
    public static void main(String[] args) {
//        String empList[]={"subani","althaf","vamshi"};
//
//        List<String> list = Arrays.asList(empList);
//        Collections.sort(list, Comparator.reverseOrder());
//
//        System.out.println(list);


        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);


            LinkedHashMap<String, Integer> sortedMap=hm.entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).collect(Collectors.toMap(Entry::getKey, Entry::getValue,(a, b)->a,LinkedHashMap::new));

        System.out.println(sortedMap);

    }
}
