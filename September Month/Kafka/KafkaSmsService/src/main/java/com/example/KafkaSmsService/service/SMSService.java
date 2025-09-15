package com.example.KafkaSmsService.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SMSService {
    public static final String ACCOUNT_SID="ACbc1f7a3898128c481c3196d8c90f228f";
    public static final String AUTH_TOKEN="42be0d0279dc6caddd15b8c8a90c6d91";
    public static final String FROM_NUMBER="+919676278087";


    public void sendSMS(String toNumber,String textMessage){
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        Message message=Message.creator(new PhoneNumber(toNumber),new PhoneNumber(FROM_NUMBER),
                textMessage).create();

        System.out.println("SMS sent  successfully with SID! ");
    }
}
