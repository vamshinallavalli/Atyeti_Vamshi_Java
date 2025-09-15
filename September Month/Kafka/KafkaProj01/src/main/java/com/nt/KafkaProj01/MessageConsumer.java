package com.nt.KafkaProj01;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    private final MessageStore messageStore;

    public MessageConsumer(MessageStore messageStore) {
        this.messageStore = messageStore;
    }

    @KafkaListener(topics = "${app.topic.name}", groupId = "group-1")
    public void consume(String message) {
        System.out.println("📩 Message received: " + message);
        messageStore.addMessage(message);
    }
}