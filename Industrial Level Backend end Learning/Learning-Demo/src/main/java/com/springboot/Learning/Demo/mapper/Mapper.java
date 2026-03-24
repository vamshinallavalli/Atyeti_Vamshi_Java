package com.springboot.Learning.Demo.mapper;

import com.springboot.Learning.Demo.dto.*;
import com.springboot.Learning.Demo.*;
import com.springboot.Learning.Demo.entities.Project;
import com.springboot.Learning.Demo.entities.Task;
import com.springboot.Learning.Demo.entities.User;

public class Mapper {

    public static User toEntity(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static Project toEntity(ProjectDTO dto, User user) {
        Project p = new Project();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setCreatedBy(user);
        return p;
    }

    public static Task toEntity(TaskDTO dto, Project project, User user) {
        Task t = new Task();
        t.setId(dto.getId());
        t.setTitle(dto.getTitle());
        t.setDescription(dto.getDescription());
        t.setStatus(dto.getStatus());
        t.setPriority(dto.getPriority());
        t.setDeadline(dto.getDeadline());
        t.setProject(project);
        t.setAssignedTo(user);
        return t;
    }
}
