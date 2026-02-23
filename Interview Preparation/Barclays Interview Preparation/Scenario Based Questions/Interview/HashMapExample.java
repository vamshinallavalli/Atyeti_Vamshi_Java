package Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Resource {
    int id;
    String name;

    Resource(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return id == resource.id && Objects.equals(name, resource.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    //
//    @Override
//    public boolean equals(Object o) {
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return 1;
//    }

}

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




