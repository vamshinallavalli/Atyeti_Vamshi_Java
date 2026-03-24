package com.springboot.Learning.Demo.controller;

import com.springboot.Learning.Demo.dto.TaskDTO;
import com.springboot.Learning.Demo.entities.*;
import com.springboot.Learning.Demo.exception.ResourceNotFoundException;
import com.springboot.Learning.Demo.mapper.Mapper;
import com.springboot.Learning.Demo.repository.ProjectRepository;
import com.springboot.Learning.Demo.repository.UserRepository;
import com.springboot.Learning.Demo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;
    private final ProjectRepository projectRepo;
    private  final UserRepository userRepo;

    public TaskController(TaskService service, ProjectRepository projectRepo, UserRepository userRepo) {
        this.service = service;
        this.projectRepo = projectRepo;
        this.userRepo = userRepo;
    }

    @PostMapping
    public Task create(@Valid @RequestBody TaskDTO dto) {

        Project project = projectRepo.findById(dto.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        User user = userRepo.findById(dto.getAssignedToId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return service.createTask(Mapper.toEntity(dto, project, user));
    }

    @GetMapping
    public Page<Task> getAll(@RequestParam int page,
                             @RequestParam int size) {
        return service.getTasks(page, size);
    }

    @GetMapping("/status/{status}")
    public List<Task> byStatus(@PathVariable Status status) {
        return service.getByStatus(status);
    }

    @GetMapping("/priority/{priority}")
    public List<Task> byPriority(@PathVariable Priority priority) {
        return service.getByPriority(priority);
    }

    @GetMapping("/project/{id}")
    public List<Task> byProject(@PathVariable Long id) {
        return service.getByProject(id);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
