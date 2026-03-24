package com.springboot.Learning.Demo.repository;

import com.springboot.Learning.Demo.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
