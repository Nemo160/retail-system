package com.eu.retail.cashier.ui;

import com.eu.retail.core.model.*;
import javax.swing.*;
import java.awt.*;

public class CartPanel extends JPanel {
    private final int WIDTH = 200;

    private static JList<Product> cartList = new JList<>();
    public static DefaultListModel<Product> model = new DefaultListModel<>();
    static JLabel itemLabel = new JLabel();


    private JPanel numPad = new JPanel();
    private JPanel buttonsPanel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane();
    private JButton remBtn;
    public CartPanel(){

        initUI();

        add(buttonsPanel,BorderLayout.WEST);
        add(numPad,BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.EAST);


    }


    private void initUI(){
        setBackground(Color.orange);
        setBorder(BorderFactory.createTitledBorder("Cart"));
        setLayout(new BorderLayout());
       // setBorder(BorderFactory.createTitledBorder("Cart"));

        initNumPad();
        initButtons();
        initScroll();

    }
    private void initNumPad(){
        GridLayout gridLayout = new GridLayout();
        numPad.setBackground(Color.RED);
        numPad.setLayout(gridLayout);
        numPad.setPreferredSize(new Dimension(200, 350));

    }

    private void initButtons(){

        buttonsPanel.setLayout(new FlowLayout());

        remBtn = new JButton("Remove Item");
        remBtn.setMaximumSize(new Dimension(40, 40));
        remBtn.addActionListener(e -> {
            int i = cartList.getSelectedIndex();
            if(i != -1){
                model.remove(i);
            }
            //FOR DEBUGGING
            //printout();
        });
        buttonsPanel.add(remBtn);
    }

    private void initScroll(){
        scrollPane.setPreferredSize(new Dimension(250,600));
        cartList.setModel(model);
        model.addElement(new Product("test",2.0,"this is test desc", Product.PricingType.UNIT));
        model.addElement(new Product("test2",5.0,"this is test2 desc", Product.PricingType.PER_KG));

        scrollPane = new JScrollPane(cartList);
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
    public static void addItem(Product p){
        model.addElement(p);
    }

}
