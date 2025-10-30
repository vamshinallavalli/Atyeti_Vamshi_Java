package com.example.KafkaSmsService.consumer;

import com.example.KafkaSmsService.dto.SMSRequest;
import com.example.KafkaSmsService.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SMSConsumer {

    @Autowired
    private SMSService service;

    @KafkaListener(topics="${app.topic.name}",groupId = "group-2")
    public void consume(SMSRequest smsRequest){
        service.sendSMS(smsRequest.getPhoneNo(), smsRequest.getMessage());
        System.out.println("sms to"+smsRequest.getPhoneNo());
    }
}
