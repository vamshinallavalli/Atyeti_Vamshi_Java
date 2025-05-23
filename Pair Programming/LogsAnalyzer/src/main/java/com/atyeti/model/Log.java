package com.atyeti.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Log {
    private Timestamp timestamp;
    private Long userId;
    private String messageType;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Log log = (Log) object;
        return Objects.equals(timestamp, log.timestamp) && Objects.equals(userId, log.userId) && Objects.equals(messageType, log.messageType) && Objects.equals(message, log.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, userId, messageType, message);
    }

    @Override
    public String toString() {
        return "Log{" +
                "timestamp=" + timestamp + '\''+
                ", userId=" + userId +'\''+
                ", message='" + message + '\'' +
                ", messageType='" + messageType + '\'' +
                "}\n";
    }
}
