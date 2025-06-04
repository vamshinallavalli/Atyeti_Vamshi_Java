package com.atyeti;

import com.atyeti.model.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.atyeti.service.*;

import java.io.File;
import java.io.IOException;

public class Main {
    public static final String FILE_PATH = "C:\\Users\\VamshiNallavalli\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Vamshi_Java\\Pair Programming\\JsonData\\src\\main\\resources\\data.json";

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper=new ObjectMapper();


        Root root = mapper.readValue(new File(FILE_PATH), Root.class);

        ConversionService.doRename(root);

        mapper.writeValue(new File(FILE_PATH), root);

    }

}