package com.atyeti;

import com.atyeti.model.Log;
import com.atyeti.service.DBService;
import com.atyeti.service.LogService;
import com.atyeti.util.FileUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class Main{
    private static final String directoryPath="C:\\Users\\VamshiNallavalli\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Vamshi_Java\\Pair Programming\\LogsAnalyzer\\src\\main\\resources";
    private static final LogService logService=new LogService();
    private static final DBService dbService=new DBService();

    public static void main(String[] args) throws SQLException {

        // Read data from directory and store data in a List

        List<Log> logsData= FileUtil.readData(directoryPath);

          //System.out.println(logsData);
//        System.out.println("Number of Objects Stored: "+logsData.size());


        // Perform Operations on counts ERROR INFO WARNING

        Map<String,Long> frequencies=logService.getFrequencyOfMessageType(logsData);

//        System.out.println(frequencies);

        // Creating connection with database
        dbService.createConnection("jdbc:mysql://localhost:3306/log_analyzer","root","42379");

        // Store Updated data or Processed data into database

        String query="insert into log_summary(error_count,warning_count,info_count) values (" +
                frequencies.get("ERROR")+"," +
                frequencies.get("WARNING")+"," +
                frequencies.get("INFO")+
                ");";
        dbService.executeUserQuery(query);

    }
}