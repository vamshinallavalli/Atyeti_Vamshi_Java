
package com.atyeti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class LogFileAnalyzerApp {

    public static final String filepath = "C:\\Users\\VamshiNallavalli\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Vamshi_Java\\June Month\\Multi Threading\\projects\\LogFileAnalyzerSystem\\src\\main\\java\\com\\atyeti\\logs";

    public static void main(String[] args) {
        File folder = new File(filepath);
        File[] files = folder.listFiles((d, name) -> name.endsWith(".log"));

        if (files == null || files.length == 0) {
            System.out.println("No .log files found in directory: " + filepath);
            return;
        }

        for (File file : files) {
            System.out.println("Processing file: " + file.getName());
            List<String> logs = readFile(file.getAbsolutePath());
            System.out.println("Total lines read: " + logs.size());
            System.out.println("--------------------------------------------------");
        }
    }

    private static List<String> readFile(String absolutePath) {
        List<String> listOfLogs = new ArrayList<>();
        int errorCount = 0, warnCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(absolutePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listOfLogs.add(line);

                if (line.contains("ERROR")) {
                    errorCount++;
                } else if (line.contains("WARN")) {
                    warnCount++;
                }
            }

            System.out.println("Error Count: " + errorCount);
            System.out.println("Warn Count : " + warnCount);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfLogs;
    }
}
