package com.eu.retail.cashier.ui.model;

import com.eu.retail.core.model.Product;
import com.eu.retail.core.model.UnitProduct;
import com.eu.retail.core.model.WeightedProduct;

import java.util.ArrayList;
import java.util.List;

public class TestProductList {
    List<Product> productList = new ArrayList<>();

    public TestProductList() {
        productList.add(new UnitProduct(93, "Cereal", 25.0, "Cereal"));
        productList.add(new WeightedProduct(103, "Apple", 0.2, "de"));
    }

    public List<Product> getProductList(){
        return productList;
    }
}
