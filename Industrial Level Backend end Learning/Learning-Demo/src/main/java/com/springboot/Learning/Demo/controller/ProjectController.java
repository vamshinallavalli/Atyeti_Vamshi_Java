package com.springboot.Learning.Demo.controller;

import com.springboot.Learning.Demo.dto.ProjectDTO;
import com.springboot.Learning.Demo.entities.Project;
import com.springboot.Learning.Demo.entities.User;
import com.springboot.Learning.Demo.exception.ResourceNotFoundException;
import com.springboot.Learning.Demo.mapper.Mapper;
import com.springboot.Learning.Demo.repository.UserRepository;
import com.springboot.Learning.Demo.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service;
    private final UserRepository userRepo;

    public ProjectController(ProjectService service, UserRepository userRepo) {
        this.service = service;
        this.userRepo = userRepo;
    }

    @PostMapping
    public Project create(@Valid @RequestBody ProjectDTO dto) {
        User user = userRepo.findById(dto.getCreatedById())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return service.createProject(Mapper.toEntity(dto, user));
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
