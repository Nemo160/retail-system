package com.eu.retail.cashier.ui;

import com.eu.retail.core.model.*;
import javax.swing.*;
import java.awt.*;

public class CartPanel extends JPanel {
    private final int WIDTH = 200;

    private static JList<Product> cartList = new JList<>();
    public static DefaultListModel<Product> model = new DefaultListModel<>();
    static JLabel itemLabel = new JLabel();

    private JButton[] btns = new JButton[15];
    private String[] symbols ={
            "Enter", "Clear", "⌫",
            "7", "8", "9",
            "4","5","6",
            "1","2","3",
            ".","0","00"
    };
    JTextArea input = new JTextArea(1,10);


    private JPanel numPad = new JPanel(new GridLayout(5,3));
    private JPanel buttonsPanel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane();
    private JButton remBtn;


    public CartPanel(){
        setBackground(Color.orange);
        setBorder(BorderFactory.createTitledBorder("Cart"));
        setLayout(new BorderLayout());

        initNumPad();
        initButtons();
        initScroll();
        input.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        input.setPreferredSize(new Dimension(Component.WIDTH,25));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(buttonsPanel, BorderLayout.SOUTH);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(input, BorderLayout.NORTH);
        bottomPanel.add(numPad, BorderLayout.CENTER);


        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

    }


    private void initNumPad(){
        numPad.setBackground(Color.RED);
        numPad.setPreferredSize(new Dimension(200, 350));
        for(int i =0; i<btns.length;i++){
            btns[i] = new JButton(symbols[i]);

            btns[i].setOpaque(true);
            btns[i].setBorderPainted(false);
            btns[i].setBackground(Color.gray);
            btns[i].setForeground(Color.WHITE);

            btns[i].addActionListener(e->{
                JButton btn = (JButton) e.getSource();
                handleNumPadInput(btn.getText());
            });
            numPad.add(btns[i]);
        }


    }

    private void initButtons(){

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        remBtn = new JButton("Remove Item");
        remBtn.addActionListener(e -> {
            int i = cartList.getSelectedIndex();
            if(i != -1){
                model.remove(i);
            }
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
        model.addElement(new Product("test",2.0,"this is test desc", Product.PricingType.UNIT));
        model.addElement(new Product("test2",5.0,"this is test2 desc", Product.PricingType.PER_KG));

        scrollPane = new JScrollPane(cartList);
        scrollPane.setPreferredSize(new Dimension(250,600));

    }
    private void handleNumPadInput(String value){
        String current = input.getText();
        if(value.contains("⌫")){
            if(!current.isEmpty()){
                input.setText(current.substring(0,current.length()-1));
            }
            return;
        }
        if(value.equals(".") && current.contains(".")) {
            return;
        }
        if(value.equals("Enter")){
            //if we are searching for something then put the itemID in the cartlist/model
            //if we are entering values such as weight then enter the weight send the value to be caluclated for the price of the item in weight.
            current.trim();
            System.out.println(current);
            return;
        }
        if(value.equals("Clear")){
            input.setText("");
            return;
        }
        input.setText(input.getText() + value);
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
