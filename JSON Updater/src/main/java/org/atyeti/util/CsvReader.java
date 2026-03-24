package org.atyeti.util;

import org.atyeti.model.CsvRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<CsvRecord> read(String filePath) throws IOException {
        List<CsvRecord> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);

                if (parts.length < 5) continue;

                records.add(new CsvRecord(parts));
            }
        }

        return records;
    }
}