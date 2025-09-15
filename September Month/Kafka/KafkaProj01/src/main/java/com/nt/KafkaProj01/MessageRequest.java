package com.nt.KafkaProj01;

public class MessageRequest {
    private String msg;
    private String toEmail;

    public MessageRequest() {}

    public MessageRequest(String msg, String toEmail) {
        this.msg = msg;
        this.toEmail = toEmail;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }
}