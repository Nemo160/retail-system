package com.eu.retail.cashier.ui;

import com.eu.retail.core.model.Product;

import javax.swing.*;

import java.awt.*;

import static com.eu.swingkit.window.Frames.createFrame;

public class CashierFrame extends JFrame{
    public CashierFrame(){
        setTitle("Cashier");
        setSize(1000,700);
        setLocationRelativeTo(null);
        //setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(mainPanel);

        initUI(mainPanel);

    }
    private void initUI(JPanel main){
        CartPanel cart = new CartPanel();
        cart.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        main.add(cart,BorderLayout.EAST);


        //DEBUGG TEST ADD
        JButton testButton = new JButton("ADD");
        testButton.addActionListener(e->{
           addTest();
        });
        main.add(testButton);


        // main.add(test,BorderLayout.EAST);
       // this.pack();
    }

    private void addTest(){
        CartPanel.addItem(new Product("APPLE",20.0,"thistestAPPLE", Product.PricingType.UNIT));
        this.repaint();
    }


}
