package com.nt.KafkaProj01;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageProducer producer;
    private final MessageStore messageStore;
    private final EmailService emailService;

    public MessageController(MessageProducer producer, MessageStore messageStore, EmailService emailService) {
        this.producer = producer;
        this.messageStore = messageStore;
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody MessageRequest request) {
        String msg = request.getMsg();
        String recipient = request.getToEmail() != null ? request.getToEmail() : emailService.getDefaultRecipient();

        // Send to Kafka
        producer.sendMessage(msg);

        // Send Email
        emailService.sendEmail("New Kafka Message", msg, recipient);

        return "Message sent to Kafka & Email: " + msg + " to " + recipient;
    }


    @GetMapping("/all")
    public List<String> getAllMessages() {
        return messageStore.getAllMessages();
    }
}