package com.eu.retail.cashier.ui;

import com.eu.retail.cashier.controller.CartController;
import com.eu.retail.cashier.controller.NumPadController;
import com.eu.retail.cashier.controller.SearchController;
import com.eu.retail.core.model.Product;

import javax.swing.*;
import java.awt.*;

public class NumPadPanel extends JPanel {
    private  DefaultListModel<Product> model;
    private JButton[] btns = new JButton[15];
    private String[] symbols ={
            "Enter", "Clear", "⌫",
            "7", "8", "9",
            "4","5","6",
            "1","2","3",
            ".","0","00"
    };
    JTextArea input = new JTextArea(1,10);


    SearchController searchController;
    NumPadController numPadController = new NumPadController();
    JPanel topPanel = new JPanel(new BorderLayout());
    JPanel bottomPanel = new JPanel(new BorderLayout());
    private final CartController cartController;

    public NumPadPanel(CartController cartController, SearchController searchController){
        this.model= model;
        this.cartController = cartController;
        this.searchController = searchController;
        setLayout(new BorderLayout());
        setBackground(Color.RED);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));


        //input window panel
        input.setFont(new Font("Arial", Font.BOLD,18));
        topPanel.add(input, BorderLayout.CENTER);

        //numbers panel
        bottomPanel.setLayout(new GridLayout(5,3));
        initBtn();

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);

        input.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    private void initBtn(){

        for(int i =0; i<btns.length;i++){
            btns[i] = new JButton(symbols[i]);

            btns[i].setOpaque(true);
            btns[i].setBorderPainted(false);
            btns[i].setBackground(Color.gray);
            btns[i].setForeground(Color.WHITE);

            btns[i].addActionListener(e->{
                String sourceText = ((JButton) e.getSource()).getText();
                String inputText = numPadController.handleNumPadInput(input.getText(), sourceText);
                if(sourceText.equals("Enter")){
                    searchController.searchByPnuAndAdd(Integer.parseInt(inputText));
                    input.setText("");
                }
                else{
                    input.setText(inputText);
                }
                //Controller returns inputText

                /*This could be either PRODUCT ID, PRODUCT WEIGHT OR PRICE
                * DEFAULT: product id, so we can quickly add the product to the cart
                  OPTION 2: Enter weight when prompted.
                  OPTION 3: Set price when prompted.
                  * for now, we have simply print out what has been input.
                * */

            });
            bottomPanel.add(btns[i]);
        }

    }
}
