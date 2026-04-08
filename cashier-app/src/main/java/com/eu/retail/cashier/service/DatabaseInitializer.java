package com.eu.retail.cashier.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {
        String sql = """
                CREATE TABLE IF NOT EXISTS products (
                    pnu INTEGER PRIMARY KEY,
                    name TEXT NOT NULL,
                    price REAL NOT NULL,
                    description TEXT,
                    is_weighted INTEGER NOT NULL
                );
                """;

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}