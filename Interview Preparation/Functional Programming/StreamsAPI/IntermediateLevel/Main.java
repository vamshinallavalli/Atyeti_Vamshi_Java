package IntermediateLevel;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee(1, "Vamshi", 45000.0);
        Employee employee2 = new Employee(2, "Ravi", 52000.0);
        Employee employee3 = new Employee(3, "Anil", 48000.0);
        Employee employee4 = new Employee(4, "Kiran", 60000.0);
        Employee employee5 = new Employee(5, "Suresh", 55000.0);

        List<Employee> employees=List.of(employee1,employee2,employee3,employee4,employee5);

        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);


       

    }
}

