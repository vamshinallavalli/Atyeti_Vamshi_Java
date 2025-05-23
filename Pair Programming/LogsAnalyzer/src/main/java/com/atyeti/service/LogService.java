package com.atyeti.service;

import com.atyeti.model.Log;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogService {
    public Map<String, Long> getFrequencyOfMessageType(List<Log> logsData) {
        return logsData.stream()
                .collect(Collectors.groupingBy(Log::getMessageType,Collectors.counting()));
    }
}
