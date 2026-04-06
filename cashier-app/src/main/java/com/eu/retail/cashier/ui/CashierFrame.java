package com.eu.retail.cashier.ui;

import com.eu.retail.core.model.Product;

import javax.swing.*;

import java.awt.*;


public class CashierFrame extends JFrame{
    public CashierFrame(){
        setTitle("Cashier");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initUI();
        setVisible(true);

    }
    private void initUI(){
        CartPanel cart = new CartPanel();
        cart.setPreferredSize(new Dimension(400,700));

        //DEBUGG TEST ADD, implement addItem to cartpanel
        JPanel tempPanel = new JPanel();
        JButton testButton = new JButton("APPLE");
        testButton.setPreferredSize(new Dimension(100,100));
        testButton.addActionListener(e->{
           addTest();
        });
        tempPanel.add(testButton);

        add(tempPanel, BorderLayout.CENTER);
        add(cart, BorderLayout.EAST);
        //panel.add(cart);



        // main.add(test,BorderLayout.EAST);
       // this.pack();
    }

    private void addTest(){
        CartPanel.addItem(new Product("APPLE",20.0,"thistestAPPLE", Product.PricingType.UNIT));
        this.repaint();
    }


}
