package com.springboot.Learning.Demo.controller;


import com.springboot.Learning.Demo.dto.UserDTO;
import com.springboot.Learning.Demo.entities.User;
import com.springboot.Learning.Demo.mapper.Mapper;
import com.springboot.Learning.Demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserDTO create(@Valid @RequestBody UserDTO dto) {
        User user = service.createUser(Mapper.toEntity(dto));
        return Mapper.toDTO(user);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return service.getAllUsers()
                .stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }
}