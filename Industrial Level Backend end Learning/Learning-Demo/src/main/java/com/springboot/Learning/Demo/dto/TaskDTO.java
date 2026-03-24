package com.springboot.Learning.Demo.dto;

import com.springboot.Learning.Demo.entities.Priority;
import com.springboot.Learning.Demo.entities.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDTO {

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private Status status;
    private Priority priority;

    private LocalDate deadline;

    private Long projectId;
    private Long assignedToId;
}
