package com.atyeti.BootJMSProj01_SenderApp_Scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PTPSender {

    @Autowired
    private JmsTemplate template;

    @Scheduled(cron = "*/10 * * * * *")
    public void sendMessage() {
        template.send("testmq2", session ->
                session.createTextMessage("From the Sender :: " + new Date()));

        System.out.println("Sender has sent the message at " + new Date());
    }
}