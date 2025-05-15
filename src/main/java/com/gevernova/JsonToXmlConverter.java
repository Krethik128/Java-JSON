package com.gevernova;

import org.json.JSONObject;
import org.json.XML;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToXmlConverter {
    public static void main(String[] args) throws Exception {
        String jsonString = Files.readString(Paths.get("student.json"));
        JSONObject json = new JSONObject(jsonString);

        String xml = XML.toString(json);
        System.out.println(xml);
    }
}

