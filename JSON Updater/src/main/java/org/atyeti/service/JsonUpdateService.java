package org.atyeti.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.*;

import org.atyeti.model.CsvRecord;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUpdateService {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Pattern pattern = Pattern.compile("(\\w+)\\[(\\d+)]");

    public ObjectNode loadJson(String path) throws IOException {
        return (ObjectNode) mapper.readTree(new File(path));
    }

    public void applyUpdates(ObjectNode root, List<CsvRecord> records) {

        for (CsvRecord record : records) {

            switch (record.operation) {
                case "I":
                case "U":
                    applyPath(root, record.path, record.newValue);
                    break;

                case "D":
                    deletePath(root, record.path);
                    break;
            }
        }
    }

    private void applyPath(ObjectNode root, String path, String value) {

        String[] tokens = path.split("\\.");
        JsonNode current = root;

        for (int i = 0; i < tokens.length; i++) {

            String token = tokens[i];
            Matcher matcher = pattern.matcher(token);

            if (matcher.matches()) {
                String field = matcher.group(1);
                int index = Integer.parseInt(matcher.group(2));

                ArrayNode array = ((ObjectNode) current).withArray(field);

                while (array.size() <= index) {
                    array.add(mapper.createObjectNode());
                }

                current = array.get(index);

            } else {

                if (i == tokens.length - 1) {
                    ((ObjectNode) current).set(token, parseValue(value));
                } else {
                    current = ((ObjectNode) current).with(token);
                }
            }
        }
    }

    private void deletePath(ObjectNode root, String path) {
        String[] tokens = path.split("\\.");
        JsonNode current = root;

        for (int i = 0; i < tokens.length - 1; i++) {
            current = current.get(tokens[i]);
            if (current == null) return;
        }

        ((ObjectNode) current).remove(tokens[tokens.length - 1]);
    }

    private JsonNode parseValue(String value) {
        try {
            // Try parsing as proper JSON
            return mapper.readTree(value);
        } catch (Exception e) {
            // Fallback: treat as plain string
            return TextNode.valueOf(value);
        }
    }

    public void writeJson(ObjectNode root, String outputPath) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), root);
    }
}