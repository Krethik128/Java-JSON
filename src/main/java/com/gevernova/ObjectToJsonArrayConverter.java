package com.gevernova;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class User {
    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ObjectToJsonArrayConverter {
    public static void main(String[] args) throws Exception {
        List<User> users = Arrays.asList(
                new User("Alice", 30),
                new User("Bob", 22)
        );

        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
        System.out.println(jsonArray);
    }
}
