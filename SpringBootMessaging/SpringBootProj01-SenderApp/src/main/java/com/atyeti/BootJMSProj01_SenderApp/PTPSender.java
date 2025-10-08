package com.atyeti.BootJMSProj01_SenderApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PTPSender implements CommandLineRunner {

    @Autowired
    private JmsTemplate template;

    @Override
    public void run(String... args) throws Exception {
        template.send("Revathi",ses->ses.createTextMessage("from the Sender::"+new Date()));
        System.out.println("Sender has Sent the Message");
    }
}
