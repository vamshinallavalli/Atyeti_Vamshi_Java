package com.learningDeployment.Deploy.service;

import java.util.List;

import com.learningDeployment.Deploy.entity.User;
import com.learningDeployment.Deploy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteUser(int id) {
        repo.deleteById(id);
    }
}

