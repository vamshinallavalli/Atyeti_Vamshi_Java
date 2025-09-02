package com.atyeti.example;

import com.atyeti.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class PTPSender implements CommandLineRunner {

    @Autowired
    private JmsTemplate template;

    @Override
    public void run(String... args) throws Exception {
        Product prod=new Product(1001,"raja",10.0f,40000.0f);
        template.convertAndSend("testmq4",prod);
        System.out.println("Sender has Sent the Object as the Message"+prod);
    }
}
