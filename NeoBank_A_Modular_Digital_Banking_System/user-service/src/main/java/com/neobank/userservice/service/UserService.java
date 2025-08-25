package com.neobank.userservice.service;

import com.neobank.userservice.dto.UserDto;
import com.neobank.userservice.entity.User;
import com.neobank.userservice.exception.UserNotFoundException;
import com.neobank.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserDto convertToDto(User user) {
        UserDto dto = new UserDto();
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setPassword(user.getPassword());
        return dto;
    }

    private User convertToEntity(UserDto dto) {
        User user = new User();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());
        return user;
    }

    public UserDto getUserById(Long id) {
        logger.info("Fetching user by ID: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found!"));
        logger.debug("User found: {}", user);
        return convertToDto(user);
    }

    public UserDto registerUser(UserDto dto) {
        logger.info("Registering new user with email: {}", dto.getEmail());
        User user = convertToEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        logger.debug("User saved: {}", user);
        return convertToDto(user);
    }

    public UserDto updateUser(Long id, User updatedUser) {
        logger.info("Updating user with ID: {}", id);

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found!"));


        if (updatedUser.getFullName() != null && !updatedUser.getFullName().isEmpty()) {
            existingUser.setFullName(updatedUser.getFullName());
        }

        if (updatedUser.getEmail() != null && !updatedUser.getEmail().isEmpty()) {
            existingUser.setEmail(updatedUser.getEmail());
        }

        if (updatedUser.getPhone() != null && !updatedUser.getPhone().isEmpty()) {
            existingUser.setPhone(updatedUser.getPhone());
        }

        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }


        User savedUser = userRepository.save(existingUser);

        logger.debug("User updated successfully: {}", savedUser);

        return convertToDto(savedUser);
    }

    public String deleteUser(Long id) {
        logger.info("Deleting user with ID: {}", id);
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found!"));
        userRepository.deleteById(id);
        logger.info("User deleted successfully: {}", id);
        return "User Deleted Successfully";
    }

    public String userLogin(String userName, String password) {
        Optional<User> byEmail = userRepository.findByEmail(userName);
        if(byEmail.isPresent()) {
            User user = byEmail.get();

            if (passwordEncoder.matches(password, user.getPassword())) {
                return "Login successful";
            } else {
                return "Invalid Password Try Again!";
            }
        }
        else{
            return "User Not Found with "+userName+"!";
        }
    }
}


/*package com.neobank.userservice.service;

import com.neobank.userservice.dto.UserDto;
import com.neobank.userservice.entity.User;
import com.neobank.userservice.exception.UserNotFoundException;
import com.neobank.userservice.mapper.UserMapper;
import com.neobank.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDto getUserById(Long id) {
        logger.info("Fetching user by ID: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found!"));
        logger.debug("User found: {}", user);
        return userMapper.toDto(user);
    }

    public UserDto registerUser(UserDto dto) {
        logger.info("Registering new user with email: {}", dto.getEmail());
        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        logger.debug("User saved: {}", user);
        return userMapper.toDto(user);
    }

    public UserDto updateUser(Long id, UserDto updatedDto) {
        logger.info("Updating user with ID: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found!"));

        if (updatedDto.getFullName() != null) user.setFullName(updatedDto.getFullName());
        if (updatedDto.getEmail() != null) user.setEmail(updatedDto.getEmail());
        if (updatedDto.getPhone() != null) user.setPhone(updatedDto.getPhone());

        if (updatedDto.getPassword() != null && !updatedDto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(updatedDto.getPassword()));
        }

        userRepository.save(user);
        logger.debug("User updated: {}", user);
        return userMapper.toDto(user);
    }

    public String deleteUser(Long id) {
        logger.info("Deleting user with ID: {}", id);
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found!"));
        userRepository.deleteById(id);
        logger.info("User deleted successfully: {}", id);
        return "User Deleted Successfully";
    }
}*/