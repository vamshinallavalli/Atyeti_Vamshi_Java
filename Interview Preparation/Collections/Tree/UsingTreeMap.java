package Tree;

import java.util.Map;
import java.util.TreeMap;

public class UsingTreeMap {

    public static void main(String args[]) {

        Map m = new TreeMap();

        m.put(new Employee(1), 1);
        m.put(new Employee(2), 2);

        System.out.println(m.size());

        m.get(1).hashCode();
    }
}

class Employee implements Comparable<Employee>{
    private int id;

    public Employee(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Employee e) {
            return Integer.compare(this.id, e.id);
        }
}

