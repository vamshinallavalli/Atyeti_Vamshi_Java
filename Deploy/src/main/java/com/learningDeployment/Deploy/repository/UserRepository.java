package com.learningDeployment.Deploy.repository;

import com.learningDeployment.Deploy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}

