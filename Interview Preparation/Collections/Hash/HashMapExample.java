package Hash;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {

        Map<Resource, String> map = new HashMap<>();
        Resource resource1 = new Resource(1, "A");
        map.put(resource1, resource1.name);
        Resource resource2 = new Resource(1, "A");
        map.put(resource2,  resource2.name);

        System.out.println(map.size());
    }
}


class Resource {
    int id;
    String name;

    Resource(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
