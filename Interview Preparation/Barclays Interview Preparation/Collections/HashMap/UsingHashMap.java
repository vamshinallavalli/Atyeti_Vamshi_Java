package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UsingHashMap {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Vamshi");//14001
        Employee e2 = new Employee(2, "Vamshi");//14002

 //       System.out.println(e1==e2);
      System.out.println(e1.equals(e2));
       System.out.println(e1.hashCode());
       System.out.println(e2.hashCode());
        Map<Employee, String> map = new HashMap<>();
        map.put(e1, "Developer");

        System.out.println(map.get(e2));  //get => e1==e2=>false => null e1.euqals(e2)=>true


        HashMap<String,String> names = new HashMap<>();
        names.put("Shoheb","Pathan");
        names.put("Vamshi","nalavali");
        names.put("Althaf","Ahemd");
        String firstName="Althaf";

        System.out.println(names.get(firstName));

    }
}


class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
        super();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee emp = (Employee) o;
        return id == emp.id && name.equals(emp.name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
