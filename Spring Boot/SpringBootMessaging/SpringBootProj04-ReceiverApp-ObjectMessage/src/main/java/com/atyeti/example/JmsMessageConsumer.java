package com.atyeti.example;

import com.atyeti.example.model.Product;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageConsumer {

    @JmsListener(destination = "testmq4")
    public void readMessage(Product text){
        System.out.println("Received Message::"+text);
    }
}
