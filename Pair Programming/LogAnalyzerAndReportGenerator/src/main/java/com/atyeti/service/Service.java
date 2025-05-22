package com.atyeti.service;

import com.atyeti.db.JDBCConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Service {

   // Reads multiple large log files from a directory (file handling).
   public static void readerConnection() throws IOException {

       String filePath = "C:\\Users\\VamshiNallavalli\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Vamshi_Java\\Pair Programming\\LogAnalyzerAndReportGenerator\\log\\app1.log";

       int infoCount = 0;
       int errorCount = 0;
       int warningCount = 0;

       try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
           String line = "";

           while ((line = reader.readLine()) != null) {
               if (line.contains("INFO")) infoCount++;
               if (line.contains("ERROR")) errorCount++;
               if (line.contains("WARNING")) warningCount++;
           }

       } catch (Exception e) {
           System.err.println("File Not Found");
       }
       System.out.println("INFO Count: " + infoCount + "\n" + "ERROR Count: " + errorCount + "\n" + "WARNING Count: " + warningCount);

       JDBCConnection.connectDB(infoCount, errorCount, warningCount);
   }

   // Counts error, warning and info messages  frequency

   // Stores the data into a relational database using JDBC (JDBC).

   // Handles all possible exceptions gracefully and logs any failures in a separate error log file (error handling).
}