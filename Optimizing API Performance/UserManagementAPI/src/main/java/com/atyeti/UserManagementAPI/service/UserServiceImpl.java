package com.atyeti.UserManagementAPI.service;

import com.atyeti.UserManagementAPI.dto.UserDTO;
import com.atyeti.UserManagementAPI.entity.User;
import com.atyeti.UserManagementAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
class UserServiceImpl implements UserService{

    private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;


    @Override
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(u->u.getPassword().equals(password))
                .orElseThrow(()-> new RuntimeException("Invalid Credentials"));
    }

    @Override
    @Cacheable(value="users",key="#id")
    public UserDTO getUserById(Long id) {
        simulateDelay();
        User user= userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User Not Found"));
        return convertToDTO(user);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(),user.getName(),user.getEmail());
    }

    @Override
    public List<UserDTO> getAllUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page,size)).getContent().stream().map(this::convertToDTO).toList();
    }

        private void simulateDelay() {
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
