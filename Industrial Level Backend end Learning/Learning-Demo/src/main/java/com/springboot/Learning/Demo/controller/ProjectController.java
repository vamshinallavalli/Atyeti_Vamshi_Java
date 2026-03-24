package com.springboot.Learning.Demo.controller;

import com.springboot.Learning.Demo.entities.Project;
import com.springboot.Learning.Demo.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    public Project create(@RequestBody Project project) {
        return service.createProject(project);
    }

    @GetMapping
    public List<Project> getAll() {
        return service.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getOne(@PathVariable Long id) {
        return service.getProject(id);
    }
}
