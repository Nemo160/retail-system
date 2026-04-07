package com.eu.retail.cashier.ui.controller;

import com.eu.retail.cashier.ui.model.TestProductList;
import com.eu.retail.core.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchController {
    TestProductList testproductList = new TestProductList();
    List<Product> productList;
    public SearchController(){
        productList = testproductList.getProductList();
    }

    public Product findByPnu(String p){
        int pnu = Integer.parseInt(p);
        for(Product i : productList){
            if((i.getPnu() == pnu)){
                return i;
            }
        }
        return null;
    }

}
