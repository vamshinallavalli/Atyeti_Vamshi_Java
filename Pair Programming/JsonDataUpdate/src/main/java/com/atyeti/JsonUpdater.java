package com.atyeti;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import static com.atyeti.Main.FILE_PATH;

public class JsonUpdater {
    private static final Logger logger=Logger.getLogger(JsonUpdater.class.getName());
    public static void doUpdate() {

        try {

            // Reading
            FileReader reader=new FileReader(FILE_PATH);
            JsonObject jsonObject= JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            // updating name inside department array and team array inside

            if(jsonObject.has("departments")){
                jsonObject.getAsJsonArray("departments").forEach(deptName->{
                    JsonObject department=deptName.getAsJsonObject();

                    if(department.has("name")){
                        department.addProperty("name", "Souryanga's");
                    }


                    if(department.has("teams")){
                        department.getAsJsonArray("teams").forEach(teamName-> {
                            JsonObject team = teamName.getAsJsonObject();

                            if (team.has("name")) {
                                team.addProperty("name", "Manner's");
                            }


                            if(team.has("members")){
                                team.getAsJsonArray("members").forEach(memberName->{
                                    JsonObject member=memberName.getAsJsonObject();

                                    if(member.has("name")){
                                        member.addProperty("name","Devaratha's");
                                    }
                                });
                            }


                    });
                    }


                });

            }

            if(jsonObject.has("projects")){
                jsonObject.getAsJsonArray("projects").forEach(projectName->{
                    JsonObject projects=projectName.getAsJsonObject();

                    if(projects.has("name")){
                        projects.addProperty("name","Ganniya's");
                    }
                });


                // Writer

                FileWriter writer=new FileWriter(FILE_PATH);
                writer.write(jsonObject.toString());
                writer.flush();
                writer.close();
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
