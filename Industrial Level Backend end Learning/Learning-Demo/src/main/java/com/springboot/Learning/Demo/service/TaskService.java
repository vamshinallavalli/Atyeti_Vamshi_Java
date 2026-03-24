package com.springboot.Learning.Demo.service;

import com.springboot.Learning.Demo.entities.Priority;
import com.springboot.Learning.Demo.entities.Status;
import com.springboot.Learning.Demo.entities.Task;
import com.springboot.Learning.Demo.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Task createTask(Task task) {
        return repo.save(task);
    }

    public Page<Task> getTasks(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }

    public List<Task> getByStatus(Status status) {
        return repo.findByStatus(status);
    }

    public List<Task> getByPriority(Priority priority) {
        return repo.findByPriority(priority);
    }

    public List<Task> getByProject(Long projectId) {
        return repo.findByProjectId(projectId);
    }

    public Task updateTask(Long id, Task updated) {
        Task task = repo.findById(id).orElseThrow();
        task.setTitle(updated.getTitle());
        task.setStatus(updated.getStatus());
        task.setPriority(updated.getPriority());
        return repo.save(task);
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}
