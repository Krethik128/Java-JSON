package com.gevernova;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class JsonReportFromDatabase {
    public static void main(String[] args) {
        generateJsonReport("employee_report.json");
    }

    public static void generateJsonReport(String outputPath) {
        String dbUrl = "jdbc:mysql://localhost:3306/company_db";
        String username = "root";
        String password = "password";

        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ObjectMapper mapper = new ObjectMapper();
            ArrayNode employeeArray = mapper.createArrayNode();

            while (rs.next()) {
                ObjectNode emp = mapper.createObjectNode();
                emp.put("employee_id", rs.getInt("employee_id"));
                emp.put("name", rs.getString("name"));
                emp.put("department", rs.getString("department"));
                emp.put("salary", rs.getDouble("salary"));
                employeeArray.add(emp);
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), employeeArray);
            System.out.println("JSON report generated: " + outputPath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

