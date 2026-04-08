package com.eu.retail.cashier.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String jdbcUrl = "jdbc:sqlite:/C:\\Users\\edins\\Desktop\\Projects\\retail-system\\database\\retaildb.db";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcUrl);
        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database");
            e.printStackTrace();
        }
        return null;
    }
}
