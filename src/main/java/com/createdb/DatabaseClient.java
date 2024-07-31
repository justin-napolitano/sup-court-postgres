package com.createdb;

import java.sql.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DatabaseClient {
    private Connection connection;

    public DatabaseClient(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    // Execute SQL file
    public void executeSqlFile(String filePath) throws SQLException, IOException {
        String sql = new String(Files.readAllBytes(Paths.get(filePath)));
        String[] sqlStatements = sql.split(";");

        try (Statement stmt = connection.createStatement()) {
            for (String statement : sqlStatements) {
                if (!statement.trim().isEmpty()) {
                    stmt.execute(statement.trim());
                }
            }
        }
    }

    // Create table
    public void createTable(String createTableSQL) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }

    // Insert data
    public void insertData(String insertSQL, List<Object> parameters) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }
            pstmt.executeUpdate();
        }
    }

    // Update data
    public void updateData(String updateSQL, List<Object> parameters) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }
            pstmt.executeUpdate();
        }
    }

    // Delete data
    public void deleteData(String deleteSQL, List<Object> parameters) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }
            pstmt.executeUpdate();
        }
    }

    // Query data
    public List<List<Object>> queryData(String querySQL, List<Object> parameters) throws SQLException {
        List<List<Object>> results = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(querySQL)) {
            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                int columnCount = rs.getMetaData().getColumnCount();
                while (rs.next()) {
                    List<Object> row = new ArrayList<>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.add(rs.getObject(i));
                    }
                    results.add(row);
                }
            }
        }
        return results;
    }

    // Check if table exists
    public boolean tableExists(String tableName) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        try (ResultSet rs = meta.getTables(null, null, tableName, new String[]{"TABLE"})) {
            return rs.next();
        }
    }

    // Close connection
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
