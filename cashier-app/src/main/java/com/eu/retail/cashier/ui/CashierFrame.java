package com.eu.retail.cashier.ui;

import com.eu.retail.core.model.Product;
import com.eu.retail.core.model.UnitProduct;
import com.eu.retail.core.model.WeightedProduct;

import javax.swing.*;

import java.awt.*;


public class CashierFrame extends JFrame{
    CartPanel cart = new CartPanel();
    NumPad numPad = new NumPad(cart.getModel());
    CategoriesPanel categoriesPanel = new CategoriesPanel();
    CashierOptions cashierOptions = new CashierOptions();
    public CashierFrame(){
        setTitle("Cashier");
        setSize(1280,960);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initUI();
        setVisible(true);

    }
    private void initUI(){
        JPanel mainframe = new JPanel(new BorderLayout());
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());
        //cart.setPreferredSize(new Dimension(400,700));
        rightPanel.setPreferredSize(new Dimension(CommonConstant.RIGHT_PANEL_WIDTH,CommonConstant.RIGHT_PANEL_HEIGHT));
        leftPanel.setPreferredSize(new Dimension(CommonConstant.LEFT_PANEL_WIDTH,CommonConstant.LEFT_PANEL_HEIGHT));


        //set debugging borders
        cashierOptions.setBorder(BorderFactory.createTitledBorder("Options"));
        numPad.setBorder(BorderFactory.createTitledBorder("NUMPAD"));
        cart.setBorder(BorderFactory.createTitledBorder("CART"));
        categoriesPanel.setBorder(BorderFactory.createTitledBorder("Category"));

        rightPanel.setBorder(BorderFactory.createTitledBorder("RIGHT"));
        leftPanel.setBorder(BorderFactory.createTitledBorder("LEFT"));
        rightPanel.add(cart,BorderLayout.NORTH);
        rightPanel.add(numPad,BorderLayout.SOUTH);

        leftPanel.add(cashierOptions,BorderLayout.SOUTH);
        leftPanel.add(categoriesPanel, BorderLayout.CENTER);


        //DEBUGG TEST ADD, implement addItem to cartpanel
        JButton testButton = new JButton("APPLE");
        testButton.setPreferredSize(new Dimension(100,100));
        testButton.addActionListener(e->{
           addTest();
        });

        //leftPanel.add(testButton, BorderLayout.NORTH);

        add(rightPanel,BorderLayout.EAST);
        add(leftPanel,BorderLayout.WEST);




        // main.add(test,BorderLayout.EAST);
       //this.pack();
    }

    private void addTest(){
        WeightedProduct apple = new WeightedProduct(103,"Apple", 0.2,"de");
        UnitProduct cereal = new UnitProduct(93,"Cereal",25.0,"Cereal");
        cart.addItem(apple);
        cart.addItem(cereal);
        //cart.addItem(new Product(102,"APPLE",20.0,"thistestAPPLE");
        this.repaint();
    }


}
