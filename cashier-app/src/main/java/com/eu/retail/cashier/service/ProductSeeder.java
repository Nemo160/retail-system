package com.eu.retail.cashier.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductSeeder {

    public static void seed() {
        String sql = """
                INSERT OR IGNORE INTO products (pnu, name, price, description, is_weighted)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, 93);
            ps.setString(2, "Cereal");
            ps.setDouble(3, 25.0);
            ps.setString(4, "Cereal");
            ps.setInt(5, 0);
            ps.executeUpdate();

            ps.setInt(1, 103);
            ps.setString(2, "Apple");
            ps.setDouble(3, 0.2);
            ps.setString(4, "Fruit");
            ps.setInt(5, 1);  //weight true or false
            ps.executeUpdate();


            ps.setInt(1, 55);
            ps.setString(2, "Ice cream");
            ps.setDouble(3, 55.0);
            ps.setString(4, "ice cream");
            ps.setInt(5, 0);


            ps.executeUpdate();
            ps.setInt(1, 1302);
            ps.setString(2, "Bananan");
            ps.setDouble(3, 25.0);
            ps.setString(4, "banana");
            ps.setInt(5, 1);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}