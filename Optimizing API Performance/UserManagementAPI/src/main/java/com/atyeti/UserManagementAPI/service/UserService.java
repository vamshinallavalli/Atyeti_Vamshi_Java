package com.atyeti.UserManagementAPI.service;


import com.atyeti.UserManagementAPI.dto.UserDTO;
import com.atyeti.UserManagementAPI.entity.User;

import java.util.List;

public interface UserService {
    User register(User user);
    User login(String email, String password);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers(int page, int size);
}
