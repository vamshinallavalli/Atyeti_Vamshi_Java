package HashMap;

import java.util.*;

public class Example {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);


        List<Map.Entry<String,Integer>> list= new ArrayList<>(hm.entrySet());

        list.sort((e1,e2)->e1.getValue().compareTo(e2.getValue()));


        Map<String,Integer> sorted=new LinkedHashMap<>();

        for(Map.Entry<String,Integer> x:list){
            sorted.put(x.getKey(),x.getValue());
        }

        System.out.println(sorted);

    }
}
