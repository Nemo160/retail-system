package com.eu.retail.cashier.app;

import com.eu.retail.cashier.service.DatabaseInitializer;
import com.eu.retail.cashier.service.ProductCatalog;
import com.eu.retail.cashier.service.ProductSeeder;
import com.eu.retail.cashier.ui.*;
import javax.swing.SwingUtilities;

public class CashierMain {
    public static void main(String[] args){
        //dev tool. Only use when rebuilding database for testing

       // DatabaseInitializer.initialize();

        //ProductSeeder.seed();

        ProductCatalog productCatalog = new ProductCatalog();

        SwingUtilities.invokeLater(() -> {
            new CashierFrame(productCatalog);
        });

    }
}
