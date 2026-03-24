package com.springboot.Learning.Demo.repository;

import com.springboot.Learning.Demo.entities.Priority;
import com.springboot.Learning.Demo.entities.Status;
import com.springboot.Learning.Demo.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(Status status);

    List<Task> findByPriority(Priority priority);

    List<Task> findByProjectId(Long projectId);
}
