package com.example.KafkaSmsService.controller;

import com.example.KafkaSmsService.dto.SMSRequest;
import com.example.KafkaSmsService.producer.SMSProducer;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {
    @Autowired
    private SMSProducer smsProducer;

    @PostMapping("/sms")
    public ResponseEntity<String> sendSMS(@RequestBody SMSRequest request){
       return new ResponseEntity<>( smsProducer.sendSMSRequest(request), HttpStatus.OK);
    }
}
