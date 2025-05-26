package Learning_HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo
{
    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<>();

        map.put(1,"Akshit");
        map.put(2,"Neha");
        map.put(3,"Shubham");
//        map.put(null,"Vamshi");
//        map.put(null,"Varun");
        map.put(2,"Varun");

        System.out.println(map);

       String student= map.get(3);

        System.out.println(student);

        System.out.println(map.get(88));

        System.out.println(map.containsKey(1));

        System.out.println(map.containsValue("Shubham"));

//        Set<Integer> keys = map.keySet();

        for (int i:map.keySet()){
            System.out.println(map.get(i));
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        for (Map.Entry<Integer, String> entry:entries){
            //System.out.println(entry.getValue()+" "+entry.getKey());
            entry.setValue((entry.getValue().toUpperCase()));
        }

        System.out.println(map);


//        map.remove(1);
        map.remove(1);

        System.out.println(map);

    }
}
