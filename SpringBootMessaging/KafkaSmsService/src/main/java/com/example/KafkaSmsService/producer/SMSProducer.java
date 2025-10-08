package com.example.KafkaSmsService.producer;

import com.example.KafkaSmsService.dto.SMSRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SMSProducer {

    @Autowired
    private KafkaTemplate<String, SMSRequest> template;

    @Value("${app.topic.name}")
    private String topicName;

    public String sendSMSRequest(SMSRequest smsRequest){
        template.send(topicName,smsRequest);

        return "SMS sent Successfully!";
    }
}
