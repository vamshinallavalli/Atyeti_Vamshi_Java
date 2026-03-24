package com.springboot.Learning.Demo.repository;

import com.springboot.Learning.Demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
