package com.springboot.Learning.Demo.controller;

import com.springboot.Learning.Demo.entities.Priority;
import com.springboot.Learning.Demo.entities.Status;
import com.springboot.Learning.Demo.entities.Task;
import com.springboot.Learning.Demo.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.createTask(task);
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
