package com.atyeti.BootJMSProj02_Subscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class BootJmsProj02_Subscriber {
	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj02_Subscriber.class, args);
	}
}