package HashMap;

import java.util.HashMap;
import java.util.Objects;

public class HashMap3 {
    public static void main(String[] args) {
        Employee2 e1 = new Employee2(1, "A");
        Employee2 e2 = new Employee2(1, "A");

        System.out.println(e1.equals(e2)); // true
        System.out.println(e1.hashCode() == e2.hashCode()); // true

    }
}


class Employee2{
    int id;
    String name;

    Employee2(int id,String name){
        this.id=id;
        this.name=name;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee2 employee2 = (Employee2) o;
        return id == employee2.id && Objects.equals(name, employee2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

