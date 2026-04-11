package com.eu.retail.cashier.service;

import com.eu.retail.cashier.service.db.DatabaseManager;
import com.eu.retail.core.model.Product;
import com.eu.retail.core.model.UnitProduct;
import com.eu.retail.core.model.WeightedProduct;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {

    public Product findByPnu(int pnu) {
        String sql = "SELECT * FROM products WHERE pnu = ?";

        try(Connection conn = DatabaseManager.getConnection("products");
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, pnu);

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return mapRowToProduct(rs);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public List<Product> searchByName(String name){
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name LIKE ?";

        try(Connection conn = DatabaseManager.getConnection("products");
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, "%" + name + "%");

            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    products.add(mapRowToProduct(rs));
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return products;
    }

    private Product mapRowToProduct(ResultSet rs) throws SQLException{
        int pnu = rs.getInt("pnu");
        String name = rs.getString("name");
        BigDecimal price = new BigDecimal(rs.getDouble("price"));
        String description = rs.getString("description");
        boolean isWeighted = rs.getInt("is_weighted") == 1; //set boolean if

        if(isWeighted){
            return new WeightedProduct(pnu, name, price, description);
        }
        else{
            return new UnitProduct(pnu, name, price, description);
        }
    }

    public List<Product> findByParentCategory(String parentCategoryName){
        List<Product> products = new ArrayList<>();
        String sql = """
            SELECT DISTINCT p.pnu, p.name, p.price, p.description, p.is_weighted
            FROM products p
            JOIN product_sub_categories psc ON p.pnu = psc.product_pnu
            JOIN sub_categories sc ON sc.id = psc.sub_category_id
            JOIN parent_categories pc ON pc.id = sc.parent_category_id
            WHERE pc.name = ?
            """;
        try(Connection conn = DatabaseManager.getConnection("products");
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, parentCategoryName);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    products.add(mapProducts(rs));
                }
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    //public List<Product> findBySubCategory(String subCategoryName){}

    private Product mapProducts(ResultSet rs) throws SQLException{
        int pnu = rs.getInt("pnu");
        String name = rs.getString("name");
        BigDecimal price = new BigDecimal(rs.getDouble("price"));
        String description = rs.getString("description");
        boolean isWeighted = rs.getInt("is_weighted") == 1;
        if(isWeighted){
            return new WeightedProduct(pnu, name, price, description);
        }
        else{
            return new  UnitProduct(pnu, name, price, description);
        }
    }


    //CATEGORY
    public List<Product> findBySubCategoryId(int subCategoryId){
        List<Product> products = new ArrayList<>();
        return products;
    }




}





