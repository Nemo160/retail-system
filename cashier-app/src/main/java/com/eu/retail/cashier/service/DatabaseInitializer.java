package com.eu.retail.cashier.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {
        String sql = """
                CREATE TABLE IF NOT EXISTS employee_cashier_data (
                    employeeID INTEGER PRIMARY KEY,
                    password INTEGER NOT NULL
                );
                """;

        try (Connection conn = DatabaseManager.getConnection("employee");
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}