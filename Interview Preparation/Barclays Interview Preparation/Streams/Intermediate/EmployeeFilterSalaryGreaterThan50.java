package Intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeFilterSalaryGreaterThan50 {
    public static void main(String[] args) {
        Employee emp1=new Employee(1,"vamsi",540000);
        Employee emp2=new Employee(5,"vamsi",230000);
        Employee emp3=new Employee(4,"vamsi",40000);

        Employee emp4=new Employee(3,"vamsi",50000);

        Employee emp5=new Employee(9,"vamsi",60000);
        Employee emp6=new Employee(2,"vamsi",35000);
        Employee emp7=new Employee(6,"vamsi",980000);


        ArrayList<Employee> list= new ArrayList<>(Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp6,emp7));

        List<Employee> map=list.stream().filter(s->s.getSalary()>50000).collect(Collectors.toList());
        System.out.println(map);


    }
}

class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
