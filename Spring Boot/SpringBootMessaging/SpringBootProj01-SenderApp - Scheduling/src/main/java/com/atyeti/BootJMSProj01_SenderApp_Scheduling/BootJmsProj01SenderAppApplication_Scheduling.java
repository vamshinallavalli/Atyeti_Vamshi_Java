package com.atyeti.BootJMSProj01_SenderApp_Scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootJmsProj01SenderAppApplication_Scheduling {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj01SenderAppApplication_Scheduling.class, args);
	}

}