package com.atyeti.SpringAnnotationDemo.service;

import com.atyeti.SpringAnnotationDemo.Entity.Employee;
import com.atyeti.SpringAnnotationDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    static EmployeeRepository repo;

    public static Employee service(){
        Employee employee=new Employee("Vamshi", 1160L,"Delivery");
        return employee;
    }

    public static String addEmployee(Employee employee){
        repo.save(employee);
        return "Saved";
    }
}
