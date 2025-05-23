package com.atyeti.util;

import com.atyeti.model.Log;
import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class FileUtil {

    private static final Logger logger=Logger.getLogger(FileUtil.class.getName());

    public static List<Log> readData(String directoryPath) {

        List<Log> logs = new ArrayList<>();
        File folder = new File(directoryPath);
        List<Log> currentFile;
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.getName().endsWith(".log")) {
                currentFile=readFile(file.getAbsolutePath());
                if(!logs.containsAll(currentFile)) {
                    logs.addAll(currentFile);
                }
            }
        }
        logger.info("SuccessFully Read all Files in Directory with .log extension!");
        return  logs;
    }

    private static List<Log> readFile(String absolutePath) {
        List<Log> list=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(absolutePath))){
            String line="";

            while((line=reader.readLine())!=null){
                Log log=new Log();
                String[] data = line.split(",");
                log.setTimestamp(Timestamp.valueOf(data[0]));
                log.setUserId(Long.parseLong(data[1]));
                log.setMessageType(data[2]);
                log.setMessage(data[3]);
                list.add(log);
            }

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
