package com.eu.retail.cashier.ui;

import com.eu.retail.cashier.service.ProductCatalog;
import com.eu.retail.cashier.ui.cart.CartPanel;
import com.eu.retail.cashier.ui.events.CartUIListener;
import com.eu.retail.cashier.ui.categories.CategoriesPanel;
import com.eu.retail.cashier.controller.CartController;
import com.eu.retail.cashier.controller.NumPadController;
import com.eu.retail.cashier.controller.SearchController;
import com.eu.retail.cashier.model.CartItem;
import com.eu.retail.cashier.ui.login.LoginDialog;
import com.eu.retail.cashier.ui.settings.CashierSettingsPanel;
import com.eu.retail.core.model.Employee;
import com.eu.retail.core.model.Product;
import com.eu.retail.core.model.UnitProduct;
import com.eu.retail.core.model.WeightedProduct;

import javax.swing.*;

import java.awt.*;
import java.math.BigDecimal;


public class CashierFrame extends JFrame implements CartUIListener {
   //Controllers
    private CartController cartController;
    private SearchController searchController;
    private NumPadController numPadController;

    //Panels
    private CartPanel cartPanel;
    private CategoriesPanel categoriesPanel;
    private NumPadPanel numPadPanel;
    private CashierSettingsPanel cashierSettingsPanel;

    //list
    private DefaultListModel<CartItem> model;
    private ProductCatalog productCatalog;

    private LoginDialog loginDialog;
    private Employee loggedInEmployee;
    public CashierFrame(ProductCatalog productCatalog){
        setVisible(true);

        setTitle("Cashier");
        setSize(1280,960);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        loginDialog = new LoginDialog(this);
        loginDialog.setVisible(true);
        loggedInEmployee = loginDialog.getLoggedInEmployee();

        if(loggedInEmployee == null){
            System.out.println("SUCCESS LOGIN");
            dispose();
            return;
        }
        this.productCatalog = productCatalog;
        model = new DefaultListModel<>();

        initControllers();
        initPanels();

        initUI();

        setVisible(true); //finally shows da shit

        repaint();

    }

    private void initPanels(){
        cartPanel = new CartPanel(model, cartController);
        categoriesPanel = new CategoriesPanel(cartController,searchController);
        cashierSettingsPanel = new CashierSettingsPanel();
        numPadPanel = new NumPadPanel(cartController,searchController);
    }

    private void initControllers(){
        cartController = new CartController(model,this);
        searchController = new SearchController(productCatalog,cartController);
        numPadController = new NumPadController();
    }
    private void initUI(){
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());


        //set debugging borders
        cashierSettingsPanel.setBorder(BorderFactory.createTitledBorder("Options"));
        numPadPanel.setBorder(BorderFactory.createTitledBorder("NUMPAD"));
        cartPanel.setBorder(BorderFactory.createTitledBorder("CART"));
        categoriesPanel.setBorder(BorderFactory.createTitledBorder("Category"));
        rightPanel.setBorder(BorderFactory.createTitledBorder("RIGHT"));
        leftPanel.setBorder(BorderFactory.createTitledBorder("LEFT"));


        rightPanel.add(cartPanel,BorderLayout.NORTH);
        rightPanel.add(numPadPanel,BorderLayout.CENTER);

        leftPanel.add(cashierSettingsPanel,BorderLayout.SOUTH);
        leftPanel.add(categoriesPanel, BorderLayout.CENTER);


        //DEBUGG TEST ADD, implement addItem to cartpanel
        JButton testButton = new JButton("APPLE");
        testButton.setPreferredSize(new Dimension(100,100));
        testButton.addActionListener(e-> addTest());
        cashierSettingsPanel.add(testButton);

        //leftPanel.add(testButton, BorderLayout.NORTH);

        add(rightPanel,BorderLayout.EAST);
        add(leftPanel,BorderLayout.CENTER);




        // main.add(test,BorderLayout.EAST);
       //this.pack();
    }

    private void addTest(){
        WeightedProduct apple = new WeightedProduct(103,"Apple", new BigDecimal("0.2"),"de");
        UnitProduct cereal = new UnitProduct(93,"Cereal",new BigDecimal("20.0"),"Cereal");
        Product prod = new UnitProduct(100,"test",new BigDecimal("10.0"),"testDESc");
        cartController.addProduct(apple);
        cartController.addProduct(cereal);
        cartController.addProduct(prod);

        //this.repaint();
    }


    @Override
    public void requestWeightInput(Product product) {
        cartPanel.promptForWeight(product);
    }

    @Override
    public void uiRequestUpdateCartTotal(BigDecimal sum) {
        cartPanel.updateCartTotal(sum);
    }
}
