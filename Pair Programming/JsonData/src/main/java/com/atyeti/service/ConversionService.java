package com.atyeti.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.atyeti.Main.FILE_PATH;

public class ConversionService {

    public static void readAndChange() throws IOException {

        // Reader
        FileReader reader = new FileReader(FILE_PATH);
        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        reader.close();

        // Before Change
        System.out.println("Original JSON: " + jsonObject);

         // name inside each department array & name inside each team inside each department array

        if (jsonObject.has("departments")) {
            jsonObject.getAsJsonArray("departments").forEach(deptElement -> {
                JsonObject department = deptElement.getAsJsonObject();

                if (department.has("name")) {
                    String oldName = department.get("name").getAsString();
                    department.addProperty("name", oldName + " Dept (new) ");
                }

                // Updating each team name inside the department array
                if (department.has("teams")) {
                    department.getAsJsonArray("teams").forEach(teamElement -> {
                        JsonObject team = teamElement.getAsJsonObject();

                        if (team.has("name")) {
                            String oldTeamName = team.get("name").getAsString();
                            team.addProperty("name", "Team - " + oldTeamName);
                        }
                    });
                }
            });
        }


        //  name inside each project array

        if (jsonObject.has("projects")) {
            jsonObject.getAsJsonArray("projects").forEach(projectElement -> {
                JsonObject project = projectElement.getAsJsonObject();

                if (project.has("name")) {
                    String oldProjectName = project.get("name").getAsString();
                    project.addProperty("name", oldProjectName + " Project");
                }
            });
        }

        // After Change
        System.out.println("Modified JSON: " + jsonObject);

        // Writer
        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write(jsonObject.toString());
        writer.flush();
        writer.close();

    }
}