package com.atyeti.util;

import com.atyeti.model.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import static com.atyeti.Main.directoryPath;

public class FileUtil {

    private static final Logger logger = Logger.getLogger(FileUtil.class.getName());

    public static List<Log> readData(String directoryPath) {

//        List<Log> logs = new ArrayList<>();
//        File folder = new File(directoryPath);
//        List<Log> currentFile;
//        for (File file : Objects.requireNonNull(folder.listFiles())) {
//            if (file.getName().endsWith(".log")) {
//                currentFile = readFile(file.getAbsolutePath());
//                logs.addAll(currentFile);
//            }
//        }


        List<Log> logs = Collections.synchronizedList(new ArrayList<>());
        File folder = new File(directoryPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".log"));

        if (files == null || files.length == 0) {
            logger.warning("No log files found in the directory.");
            return logs;
        }

        Thread[] threads = new Thread[files.length];

        for (int i = 0; i < files.length; i++) {
            final File file = files[i];
            threads[i] = new Thread(() -> {
                List<Log> logsFromFile = readFile(file.getAbsolutePath());
                logs.addAll(logsFromFile);
            });

            threads[i].start();
        }



        logger.info("SuccessFully Read all Files in Directory with .log extension!");
        return logs;
    }

    private static List<Log> readFile(String absolutePath) {
        List<Log> listOfLogs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(absolutePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(directoryPath + "log4.log"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" - ", 3);

                String timestampWithMillis = data[0];
                String[] timestampParts = timestampWithMillis.split(",");

                String timestampStr = timestampParts[0];
                long uniqueId = Long.parseLong(timestampParts[1]);

                Log log = new Log();
                log.setOriginalTimestamp(timestampWithMillis);
                log.setUserId(uniqueId);
                log.setMessageType(data[1]);
                log.setMessage(data[2]);

                listOfLogs.add(log);

                writer.write(line);
                writer.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfLogs;
    }

}