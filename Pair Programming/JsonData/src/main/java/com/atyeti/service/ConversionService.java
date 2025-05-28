package com.atyeti.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import static com.atyeti.Main.FILE_PATH;

public class ConversionService {

   public static void readAndChange() throws IOException {

       ObjectMapper objectMapper = new ObjectMapper();

       // Read JSON from file
       JsonNode jsonNode = objectMapper.readTree(new File(FILE_PATH));

       // Print JSON in pretty format
       String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

       System.out.println(prettyJson);

       if(jsonNode.has("name")){
           
       }
   }
}

















//        try {
//            // Reader
//            FileReader reader = new FileReader(FILE_PATH);
//            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
//            reader.close();
//
//        // Before Change
//            System.out.println("Original JSON: " + jsonObject);
//
//            // Change city to "Hyderabad" under "location"
//            if (jsonObject.has("location")) {
//                JsonObject location = jsonObject.getAsJsonObject("location");
//                if (location.has("city")) {
//                    location.addProperty("city", "Hyderabad");
//                }
//            }
//
//
//            if(jsonObject.has("department")){
//                JsonObject name=jsonObject.getAsJsonObject("Engineering");
//                name.addProperty("name","CSE");
//            }
//
//            // After Change
//            System.out.println("Modified JSON: " + jsonObject);
//
//            // Writer
//            FileWriter writer = new FileWriter(FILE_PATH);
//            writer.write(jsonObject.toString());
//            writer.flush();
//            writer.close();
//
//            System.out.println("JSON file updated successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
