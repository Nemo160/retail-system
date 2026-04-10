package com.eu.retail.cashier.app;

import com.eu.retail.cashier.service.DatabaseInitializer;
import com.eu.retail.cashier.service.EmployeeCatalog;
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
        EmployeeCatalog employeeCatalog = new EmployeeCatalog();

        System.out.print(employeeCatalog.findEmployeeById(1));

        SwingUtilities.invokeLater(() -> {
            new CashierFrame(productCatalog);
        });

    }
}
