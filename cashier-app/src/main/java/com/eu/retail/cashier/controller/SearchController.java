package com.eu.retail.cashier.controller;

import com.eu.retail.cashier.service.ProductCatalog;
import com.eu.retail.cashier.service.TestProductList;
import com.eu.retail.core.model.Product;

import java.util.List;

public class SearchController {
    private final ProductCatalog productCatalog;
    private final CartController cartController;

    public SearchController(ProductCatalog productCatalog, CartController cartController){
     this.productCatalog = productCatalog;
     this.cartController = cartController;
    }

    public void searchByPnuAndAdd(int pnu){
        Product product = productCatalog.findByPnu(pnu);
        if(product != null){
            //System.out.println("ADDING PRODUCT: " + product);
            cartController.addProduct(product);
        }
    }


}
