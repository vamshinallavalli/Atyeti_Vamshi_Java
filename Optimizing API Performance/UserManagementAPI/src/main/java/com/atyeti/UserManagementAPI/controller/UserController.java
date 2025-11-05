package com.atyeti.UserManagementAPI.controller;

import com.atyeti.UserManagementAPI.dto.UserDTO;
import com.atyeti.UserManagementAPI.entity.User;
import com.atyeti.UserManagementAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController{

    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDTO> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        return userService.getAllUsers(page,size);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email,@RequestParam String password){
        return userService.login(email,password);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }
}