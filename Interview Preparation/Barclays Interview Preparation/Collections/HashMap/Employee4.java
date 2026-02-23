package HashMap;

import java.util.Objects;

public class Employee4 {
    int id;
    String name;
    double salary;

    @Override
    public String toString() {
        return "Employee4{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    public Employee4(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee4 employee4 = (Employee4) o;
        return id == employee4.id && Double.compare(salary, employee4.salary) == 0 && Objects.equals(name, employee4.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }
}
