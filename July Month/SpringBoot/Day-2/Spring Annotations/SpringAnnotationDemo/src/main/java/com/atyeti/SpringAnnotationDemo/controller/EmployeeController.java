package com.atyeti.SpringAnnotationDemo.controller;

import com.atyeti.SpringAnnotationDemo.Entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller // Where we write actual API
@RestController // @Controller + @ResponseBody
@RequestMapping
public class EmployeeController {

    //@RequestMapping(path="/getEmployee", method= RequestMethod.GET)
    @GetMapping("/getEmployee")
    public String getEmployee(){
        return "employee";
    }

    @GetMapping("/getEmployeeById")
    public String getEmployeeById(@RequestParam(name="id") Integer employeeId){
        return "employee";
    }

    @GetMapping("/getEmployeeByPathId/{employeeId}")
    public String getEmployeeByPathId(@PathVariable Integer employeeId){
        return "employee";
    }

    //@RequestMapping(path="/addEmployee", method= RequestMethod.POST)
    @PostMapping("/addEmployee")
    public String addEmployee(Employee employee){
        return "added";
    }

    //@RequestMapping(path="/updateEmployee", method= RequestMethod.PUT)
    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        return "updated";
    }

    //@RequestMapping(path="/deleteEmployee", method= RequestMethod.DELETE)
    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(Employee employee){
        return "deleted";
    }


}