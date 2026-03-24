package com.springboot.Learning.Demo.service;

import com.springboot.Learning.Demo.entities.Project;
import com.springboot.Learning.Demo.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repo;

    public ProjectService(ProjectRepository repo) {
        this.repo = repo;
    }

    public Project createProject(Project project) {
        return repo.save(project);
    }

    public List<Project> getAllProjects() {
        return repo.findAll();
    }

    public Project getProject(Long id) {
        return repo.findById(id).orElseThrow();
    }
}
