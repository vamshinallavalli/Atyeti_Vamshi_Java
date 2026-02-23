package com.learning.LearningSpringBoot.service;

import com.learning.LearningSpringBoot.model.Employee;
import com.learning.LearningSpringBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee findById(long id) {
        return employeeRepository.findById(id).orElseThrow();
    }
}