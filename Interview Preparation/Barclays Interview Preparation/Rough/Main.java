import javafx.print.Collation;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer,Employee> treeMap=new TreeMap<>();



        treeMap.put(9,new Employee(1,"vamshi",47000));
        treeMap.put(5,new Employee(3,"shoheb",80000));
        treeMap.put(3,new Employee(9,"althaf",20000));

        List< Map.Entry<Integer,Employee>> list=new ArrayList<>(treeMap.entrySet());

       // Collections.sort(list,(e1,e2)->e1.getKey().compareTo(e2.getKey()));

        //System.out.println(list);

        // sort the treeMap by value of salary by using stream
        LinkedHashMap<Integer, Employee> collect = treeMap.entrySet().stream().sorted(Comparator.comparing(x -> x.getValue().getSalary(),Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));

        System.out.println(collect);


    }
}
