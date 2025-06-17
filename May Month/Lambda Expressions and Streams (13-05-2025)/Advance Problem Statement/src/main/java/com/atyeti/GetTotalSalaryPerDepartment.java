package com.atyeti;

import java.util.*;
import java.util.stream.Collectors;

class GetTotalSalaryPerDepartment {
    public static void main(String[] args) {
        List<Office> employees = Arrays.asList(
                new Office("Dev", 50000),
                new Office("Qa", 30000),
                new Office("Dev", 40000),
                new Office("CTO", 100000)
        );

        Map<String, Double> totalSalaryPerDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Office::getDepartment,
                        Collectors.summingDouble(Office::getSalary)
                ));

        // Print the result
        totalSalaryPerDept.forEach((dept, total) ->
                System.out.println(dept + " → " + total));
    }
}

class Office {
    String department;
    double salary;

    public Office(String department, double salary) {
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
