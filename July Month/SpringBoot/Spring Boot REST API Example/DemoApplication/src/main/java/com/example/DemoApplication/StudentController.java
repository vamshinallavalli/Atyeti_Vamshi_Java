package com.example.DemoApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/students")
    public List<String> getStudents() {
        return List.of("Alice", "Bob", "Charlie");
    }
}
