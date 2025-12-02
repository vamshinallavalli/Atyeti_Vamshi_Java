package ConcurrentCollections;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMap_Example {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        System.out.println(map.get("A"));

    }
}
