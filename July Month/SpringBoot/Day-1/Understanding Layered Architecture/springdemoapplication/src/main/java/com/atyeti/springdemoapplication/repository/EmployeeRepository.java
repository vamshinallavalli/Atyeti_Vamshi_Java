package com.atyeti.springdemoapplication.repository;

import com.atyeti.springdemoapplication.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    public Employee getEmployee(Integer id){
        // DB Operation, fetch the details for DB
       return  new Employee(1,"Vamshi","IT",23);
    }
}
