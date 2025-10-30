package com.atyeti.BootJMSProj01_SenderApp;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageConsumer {

    @JmsListener(destination = "Revathi")
    public void readMessage(String text){
        System.out.println("Received Message::"+text);
    }
}
