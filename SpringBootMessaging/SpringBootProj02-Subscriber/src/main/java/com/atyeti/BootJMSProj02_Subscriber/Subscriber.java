package com.atyeti.BootJMSProj02_Subscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {

    @JmsListener(destination = "Vamshi")
    public void readMessage(String text){
        System.out.println("Received Message::"+text);
    }
}
