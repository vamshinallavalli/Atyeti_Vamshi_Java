package com.atyeti.UserManagementAPI.service;

import com.atyeti.UserManagementAPI.dto.UserDTO;
import com.atyeti.UserManagementAPI.entity.User;
import com.atyeti.UserManagementAPI.exception.InvalidCredentialsException;
import com.atyeti.UserManagementAPI.exception.UserNotFoundException;
import com.atyeti.UserManagementAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class UserServiceImpl implements UserService{

  //  private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);

        emailService.sendEmail(
                savedUser.getEmail(),
                "Registration Successful",
                "Hello " + savedUser.getName() + ",\n\nThank you for registering with us.\n\nRegards,\nTeam User Management"
        );

        return savedUser;
    }

    @Override
    public User login(String email, String password) {
        User user= userRepository.findByEmail(email)
                .orElseThrow(()->new InvalidCredentialsException("Invalid Email or Password"));

        if(!encoder.matches(password,user.getPassword())){
            throw new InvalidCredentialsException("Invalid Email or Password");
        }

        emailService.sendEmail(
                user.getEmail(),
                "Login Successful","Hello "+user.getName()+"\n\nYou have successfully logged in.\n\nRegards,\nTeam User Management"
        );

        return user;
    }

    @Override
    @Cacheable(value="users",key="#id")
    public UserDTO getUserById(Long id) {
        simulateDelay();
        User user= userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("User Not Found"));
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
