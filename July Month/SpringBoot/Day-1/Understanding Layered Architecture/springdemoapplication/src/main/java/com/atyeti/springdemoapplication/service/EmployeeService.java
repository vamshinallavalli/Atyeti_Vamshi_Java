package com.atyeti.springdemoapplication.service;

import com.atyeti.springdemoapplication.dto.EmployeeDTO;
import com.atyeti.springdemoapplication.entity.Employee;
import com.atyeti.springdemoapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    public EmployeeDTO getEmployee(Integer id){
        //business ops
        Employee employee=employeeRepository.getEmployee(id);
        EmployeeDTO employeeDTO=new EmployeeDTO();
        return employeeDTO.EmployeeMapper(employee);
    }
}
