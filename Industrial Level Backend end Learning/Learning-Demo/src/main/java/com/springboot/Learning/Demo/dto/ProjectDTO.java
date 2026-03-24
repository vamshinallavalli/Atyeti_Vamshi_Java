package com.springboot.Learning.Demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectDTO {

    private Long id;

    @NotBlank(message = "Project name is required")
    private String name;

    private String description;

    private Long createdById;
}
