package com.example.parsings.csv;

import com.example.parsings.models.Values;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvReport  {
    JsonNode jsonNode;

    {
        try {
            jsonNode = new ObjectMapper().readTree(new File("src/main/resources/data.json"));
            CsvSchema.Builder builder = CsvSchema.builder()
                    .addColumn("Last price")
                    .addColumn("Curr1")
                    .addColumn("Curr2");

            CsvSchema csvSchema = builder.build().withHeader();

            CsvMapper csvMapper = new CsvMapper();
            csvMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
            csvMapper.writerFor(JsonNode.class)
                    .with(csvSchema)
                    .writeValue(new File("src/main/resources/data.csv"), jsonNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
