package com.eu.retail.cashier.ui;

import com.eu.retail.cashier.ui.controller.CartController;
import com.eu.retail.core.model.*;
import javax.swing.*;
import java.awt.*;

public class CartPanel extends JPanel {
    //private final int WIDTH = 200;

    private static JList<Product> cartList = new JList<>();
    public static DefaultListModel<Product> model = new DefaultListModel<>();

    private JPanel buttonsPanel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane();
    private JButton remBtn;


    CartController controller = new CartController(model);


    public CartPanel(){
        setBackground(Color.orange);
        setLayout(new BorderLayout());

        //initNumPad();
        initButtons();
        initScroll();


        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(buttonsPanel, BorderLayout.SOUTH);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        add(topPanel, BorderLayout.CENTER);


    }
    public DefaultListModel<Product> getModel(){
        return model;
    }
    private void initButtons(){

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        remBtn = new JButton("Remove Item");
        remBtn.addActionListener(e -> {
            controller.removeSelected(cartList);
            //FOR DEBUGGING
            //printout();
        });

        JButton test2 = new JButton("Test2Btn");
        JButton test3 = new JButton("Test3Btn");
        JButton test4 = new JButton("Test4Btn");



        buttonsPanel.add(remBtn);
        buttonsPanel.add(test2);
        buttonsPanel.add(test3);
        buttonsPanel.add(test4);
    }

    private void initScroll(){
        cartList.setModel(model);
        System.out.println("initScroll");
       // model.addElement(new Product(20,"test",2.0,"this is test desc"));
       // model.addElement(new Product(25,"test2",5.0,"this is test2 desc"));

        scrollPane = new JScrollPane(cartList);
        scrollPane.setPreferredSize(new Dimension(250,600));

    }


    private void printout(){
        double total = 0;
        for(int i = 0; i < model.size();i++){
            Product p = model.getElementAt(i);
            total += p.getPrice();
            System.out.println(p);
        }
        System.out.println(total);
    }


    public void addItem(Product p){
       controller.addProduct(p);
        //Here we call th
    }

}
