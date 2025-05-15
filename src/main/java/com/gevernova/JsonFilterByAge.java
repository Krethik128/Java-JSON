package com.gevernova;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JsonFilterByAge {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode users = mapper.readTree(new File("/Users/krethik/Desktop/Java-Json/src/main/java/com/gevernova/user.json"));

        for (JsonNode user : users) {
            if (user.get("age").asInt() > 25) {
                System.out.println(user.toPrettyString());
            }
        }
    }
}

