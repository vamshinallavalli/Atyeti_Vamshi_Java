package org.atyeti;

import org.atyeti.model.CsvRecord;
import org.atyeti.service.JsonUpdateService;
import org.atyeti.util.CsvReader;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        String csvPath = "src/main/resources/input.csv";
        String jsonPath = "src/main/resources/emp_1001.json";
        String outputPath = "src/main/resources/output.json";

        JsonUpdateService service = new JsonUpdateService();

        // Load JSON
        var root = service.loadJson(jsonPath);

        // Read CSV
        List<CsvRecord> records = CsvReader.read(csvPath);

        // Apply updates
        service.applyUpdates(root, records);

        // Write output
        service.writeJson(root, outputPath);

        System.out.println("✅ JSON updated successfully!");
    }
}