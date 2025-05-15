package com.gevernova;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.*;

public class CsvToJsonConverter {
    public static void main(String[] args) throws IOException {
        String csvPath = "students.csv";
        BufferedReader reader = new BufferedReader(new FileReader(csvPath));
        String headerLine = reader.readLine();
        String[] headers = headerLine.split(",");

        List<ObjectNode> jsonList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            ObjectNode studentNode = mapper.createObjectNode();
            for (int i = 0; i < headers.length; i++) {
                studentNode.put(headers[i], values[i]);
            }
            jsonList.add(studentNode);
        }

        String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonList);
        System.out.println(jsonOutput);
    }
}

