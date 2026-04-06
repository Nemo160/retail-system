package com.eu.retail.cashier.ui;

import com.eu.retail.core.model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CartPanel extends JPanel {
    private static JList<Product> cartList = new JList<>();
    public static DefaultListModel<Product> model = new DefaultListModel<>();
    static JLabel itemLabel = new JLabel();

    public CartPanel(){
        cartList.setModel(model);
        model.addElement(new Product("test",2.0,"this is test desc", Product.PricingType.UNIT));
        model.addElement(new Product("test2",5.0,"this is test2 desc", Product.PricingType.PER_KG));

        JScrollPane scrollPane = new JScrollPane(cartList);
        scrollPane.setPreferredSize(new Dimension(200,400));


        this.add(itemLabel);
        this.add(scrollPane);
        initUI();
    }

    private void initUI(){
        this.setVisible(true);
        this.setBackground(Color.orange);
        setBorder(BorderFactory.createTitledBorder("Cart"));

    }

    public static void addItem(Product p){
        model.addElement(p);
    }
    public static void removeItem(Product p){

    }
}
