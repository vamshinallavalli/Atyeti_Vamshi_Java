package Interview;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Vamshi", "IT", 75000),
                new Employee(2, "Krishna", "HR", 55000),
                new Employee(3, "Anil", "IT", 90000),
                new Employee(4, "Suresh", "Finance", 80000),
                new Employee(5, "Ramesh", "HR", 65000),
                new Employee(6, "Mahesh", "Finance", 95000),
                new Employee(7, "Naveen", "IT", 85000)
        );

        // Highest paid employee in each department
        Map<String, Optional<Employee>> result =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.maxBy(
                                        Comparator.comparing(Employee::getSalary)
                                )
                        ));

        // Print result
        result.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.get())
        );
    }
}
