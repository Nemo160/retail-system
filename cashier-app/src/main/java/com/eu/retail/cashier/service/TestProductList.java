package com.eu.retail.cashier.service;

import com.eu.retail.core.model.Product;
import com.eu.retail.core.model.UnitProduct;
import com.eu.retail.core.model.WeightedProduct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestProductList {
    List<Product> productList = new ArrayList<>();

    public TestProductList() {
        productList.add(new UnitProduct(93, "Cereal", new BigDecimal("25.0"), "Cereal"));
        productList.add(new WeightedProduct(103, "Apple", new BigDecimal("0.2"), "de"));
    }

    public List<Product> getProductList(){
        return productList;
    }
}
