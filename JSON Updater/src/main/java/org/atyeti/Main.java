package org.atyeti;

import org.atyeti.model.CsvRecord;
import org.atyeti.service.JsonUpdateService;
import org.atyeti.util.CsvReader;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length != 3) {
            System.out.println("Usage: java -jar JSON_Updater.jar <csvPath> <jsonPath> <outputPath>");
            return;
        }

        String csvPath = args[0];
        String jsonPath = args[1];
        String outputPath = args[2];

        JsonUpdateService service = new JsonUpdateService();

        var root = service.loadJson(jsonPath);
        List<CsvRecord> records = CsvReader.read(csvPath);
        service.applyUpdates(root, records);
        service.writeJson(root, outputPath);

        System.out.println("✅ JSON updated successfully!");
    }
}