package src.main.java.com.atyeti;

import src.main.java.com.atyeti.model.LogStats;
import src.main.java.com.atyeti.service.FileReaderService;
import src.main.java.com.atyeti.service.LogAnalyzerService;
import src.main.java.com.atyeti.util.LogFileFilter;

import java.io.File;

public class Main {

    public static final String filepath = "C:\\Users\\VamshiNallavalli\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Vamshi_Java\\June Month\\Multi Threading\\projects\\LogFileAnalyzerSystem\\src\\main\\java\\com\\atyeti\\logs";

    public static void main(String[] args) {
        File folder = new File(filepath);
        File[] logFiles = folder.listFiles(new LogFileFilter());

        if (logFiles == null || logFiles.length == 0) {
            System.out.println("No .log files found in directory: " + filepath);
            return;
        }

        LogAnalyzerService analyzer = new LogAnalyzerService(new FileReaderService());

        for (File logFile : logFiles) {
            System.out.println("Processing file: " + logFile.getName());
            LogStats stats = analyzer.analyze(logFile);
            System.out.println(stats);
            System.out.println("--------------------------------------------------");
        }
    }
}
