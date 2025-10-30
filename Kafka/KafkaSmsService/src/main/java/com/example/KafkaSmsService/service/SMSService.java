package com.example.KafkaSmsService.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SMSService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.from.number}")
    public String FROM_NUMBER;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public void sendSMS(String toNumber, String textMessage) {
        Message message = Message.creator(new com.twilio.type.PhoneNumber(toNumber), new PhoneNumber(FROM_NUMBER), textMessage).create();
        System.out.println("SMS sent successfully with SID: " + message.getSid());
    }
}