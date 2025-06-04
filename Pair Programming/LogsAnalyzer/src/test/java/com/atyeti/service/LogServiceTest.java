package com.atyeti.service;

import com.atyeti.model.Log;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogServiceTest {

    LogService logService = new LogService();

    @Test
    void testListOfLogFiles() {
        List<Log> logs = Arrays.asList(
                createLog("INFO"),
                createLog("INFO"),
                createLog("ERROR"),
                createLog("WARNING"),
                createLog("ERROR")
        );

        Map<String, Long> result = logService.getFrequencyOfMessageType(logs);

        assertEquals(2, result.get("INFO"));
        assertEquals(2, result.get("ERROR"));
        assertEquals(1, result.get("WARNING"));
    }

    private Log createLog(String messageType) {
        Log log = new Log();
        log.setMessageType(messageType);
        return log;
    }
}
