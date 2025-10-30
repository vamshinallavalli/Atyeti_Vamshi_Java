package com.nt.KafkaProj01;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class MessageStore {

    private final List<String> messages = new LinkedList<>();

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getAllMessages() {
        return Collections.unmodifiableList(messages);
    }
}