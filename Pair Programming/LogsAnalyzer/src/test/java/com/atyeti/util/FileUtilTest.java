package com.atyeti.util;

import com.atyeti.model.Log;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileUtilTest {

    @Test
    void testReadDataShouldNotThrowAndReturnCorrectLogs() {
        assertDoesNotThrow(() -> {
            File tempDir = Files.createTempDirectory("logtest").toFile();

            File file1 = new File(tempDir, "sample1.log");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1))) {
                writer.write("2023-06-01 12:00:00,1001 - INFO - Log message 1\n");
            }

            File file2 = new File(tempDir, "sample2.log");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
                writer.write("2023-06-01 12:01:00,1002 - ERROR - Log message 2\n");
            }

            List<Log> logs = FileUtil.readData(tempDir.getAbsolutePath());

            assertEquals(2, logs.size());

            assertEquals(1001L, logs.get(0).getUserId());
            assertEquals("INFO", logs.get(0).getMessageType());
            assertEquals("Log message 1", logs.get(0).getMessage());

            assertEquals(1002L, logs.get(1).getUserId());
            assertEquals("ERROR", logs.get(1).getMessageType());
            assertEquals("Log message 2", logs.get(1).getMessage());

            for (File file : tempDir.listFiles()) {
                file.delete();
            }
            tempDir.delete();

        }, "FileUtil.readData should not throw any exceptions and must return correct logs");
    }
}
