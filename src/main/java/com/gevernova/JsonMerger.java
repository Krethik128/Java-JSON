package com.gevernova;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class JsonMerger {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode json1 = (ObjectNode) mapper.readTree(new File("file1.json"));
        ObjectNode json2 = (ObjectNode) mapper.readTree(new File("file2.json"));

        json1.setAll(json2); // merge contents of json2 into json1
        System.out.println(json1.toPrettyString());
    }
}

