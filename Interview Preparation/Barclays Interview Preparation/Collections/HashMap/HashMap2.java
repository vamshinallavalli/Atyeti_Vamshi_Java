package HashMap;

import java.util.HashMap;
import java.util.Objects;

public class HashMap2 {
    public static void main(String[] args) {
        HashMap<Employee1,Integer> map=new HashMap<>();
        Employee1 employee1=new Employee1(1,"Vamshi");
        Employee1 employee2=new Employee1(2,"Vamshi");

        map.put(employee1,1);

        System.out.println(employee1.equals(employee2));
        System.out.println(employee1==employee2);

        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());

        System.out.println(map.get(employee2));

    }
}

class Employee1{
    int id;
    String name;

    Employee1(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
        return id == employee1.id && Objects.equals(name, employee1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
