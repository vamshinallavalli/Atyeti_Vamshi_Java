package com.atyeti.springdemoapplication.controller;

import com.atyeti.springdemoapplication.dto.EmployeeDTO;
import com.atyeti.springdemoapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer id){
       EmployeeDTO employee= employeeService.getEmployee(id);
       return ResponseEntity.ok(employee);
    }
}
