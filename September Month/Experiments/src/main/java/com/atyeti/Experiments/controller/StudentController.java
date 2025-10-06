package com.atyeti.Experiments.controller;

import com.atyeti.Experiments.dto.StudentDto;
import com.atyeti.Experiments.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // Get all students
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return service.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return service.getById(id);
    }

    // Add a new student
    @PostMapping
    public StudentDto addStudent(@RequestBody StudentDto dto) {
        return service.addStudent(dto);
    }
}