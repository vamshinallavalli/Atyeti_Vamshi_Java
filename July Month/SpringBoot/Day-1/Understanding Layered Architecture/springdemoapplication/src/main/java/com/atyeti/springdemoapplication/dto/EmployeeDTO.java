package com.atyeti.springdemoapplication.dto;

import com.atyeti.springdemoapplication.entity.Employee;

public class EmployeeDTO {
    String name;
    String dept;
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public EmployeeDTO EmployeeMapper(Employee employee){
        this.setName(employee.getName());
        this.setDept(employee.getDept());
        this.setAge(employee.getAge());
        return this;
    }
}
