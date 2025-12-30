package FailFast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UsingHashMap {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");

        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            map.put(3, "C");   // ❌ ConcurrentModificationException
        }

        System.out.println(map);

    }
}
