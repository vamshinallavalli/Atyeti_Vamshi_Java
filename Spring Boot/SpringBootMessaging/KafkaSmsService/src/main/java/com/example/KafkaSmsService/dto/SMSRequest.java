package com.example.KafkaSmsService.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SMSRequest {
    private String phoneNo;
    private String message;

    // getters & setters
    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}