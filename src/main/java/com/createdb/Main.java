package com.createdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "example";
        String password = "example";
        String dbName = "supreme_court";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // Create the database if it doesn't exist
            ResultSet resultSet = statement.executeQuery("SELECT 1 FROM pg_database WHERE datname = '" + dbName + "'");
            if (!resultSet.next()) {
                statement.executeUpdate("CREATE DATABASE \"" + dbName + "\"");
                System.out.println("Database " + dbName + " created successfully.");
            } else {
                System.out.println("Database " + dbName + " already exists.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Connect to the new database and execute SQL files to create tables
        try {
            String dbUrl = "jdbc:postgresql://localhost:5432/" + dbName;
            DatabaseClient dbClient = new DatabaseClient(dbUrl, user, password);

            // Execute SQL files to create tables
            dbClient.executeSqlFile("sql/CallNumbers.sql");
            System.out.println("Callnumbers:Good")
            dbClient.executeSqlFile("sql/Contributors.sql");
            System.out.println("Contributors:Good")
            dbClient.executeSqlFile("sql/Items.sql");
            System.out.println("Items:Good")
            dbClient.executeSqlFile("sql/Resources.sql");
            System.out.println("Resources:Good")
            dbClient.executeSqlFile("sql/Subjects.sql");
            System.out.println("Subjects:Good")

            dbClient.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
