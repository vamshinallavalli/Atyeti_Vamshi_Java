package TreeMap;

import java.util.TreeMap;

public class TreeMap1 {
    public static void main(String[] args) {
        TreeMap<Employee,Integer> map=new TreeMap();

        Employee e1=new Employee(3,"Vamshi");
        Employee e2=new Employee(2,"Kumar");
        Employee e3=new Employee(1,"Vijay");

        map.put(e1,1);
        map.put(e2,5);
        map.put(e3,2);


        System.out.println(map);
    }
}

class Employee implements Comparable<Employee>{
    int id;
    String name;

    Employee(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.id,o.id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
