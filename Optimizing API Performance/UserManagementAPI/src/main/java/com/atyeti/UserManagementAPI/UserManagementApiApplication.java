package com.atyeti.UserManagementAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class UserManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApiApplication.class, args);
	}

}
