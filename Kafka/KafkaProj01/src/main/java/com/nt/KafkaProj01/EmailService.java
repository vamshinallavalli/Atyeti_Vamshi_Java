package com.nt.KafkaProj01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${app.mail.to}")
    private String defaultRecipient;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendEmail(String subject, String body) {
        sendEmail(subject, body, defaultRecipient);
    }

    public void sendEmail(String subject, String body, String recipient) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
        System.out.println("📧 Email sent: " + body + " to " + recipient);
    }

    public String getDefaultRecipient() {
        return defaultRecipient;
    }
}