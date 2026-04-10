package com.eu.retail.cashier.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String productUrl = "jdbc:sqlite:/C:\\Users\\edins\\Desktop\\Projects\\retail-system\\database\\retaildb.db";

    private static final String employeesUrl = "jdbc:sqlite:/C:\\Users\\edins\\Desktop\\Projects\\retail-system\\database\\employeedb.db";
    public static Connection getConnection(String databaseName) {
        try {
            if(databaseName.equals("products")) {
                return DriverManager.getConnection(productUrl);
            }
            if(databaseName.equals("employees")) {
                return DriverManager.getConnection(employeesUrl);
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to SQLite database");
            e.printStackTrace();
        }
        return null;
    }
}
