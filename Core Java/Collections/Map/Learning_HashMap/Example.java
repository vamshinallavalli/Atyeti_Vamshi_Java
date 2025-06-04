package Learning_HashMap;

import java.util.HashMap;

public class Example {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();

        map.put("Apple",50);
        map.put("Banana",30);
        map.put("Orange",80);
        map.put("Grape",20);

        System.out.println(map.get("Grape") + " " + map.get("Orange"));
    }
}
