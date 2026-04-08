package com.eu.retail.cashier.ui;

import com.eu.retail.cashier.ui.controller.CartController;
import com.eu.retail.cashier.ui.model.CartItem;
import com.eu.retail.core.model.*;
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class CartPanel extends JPanel implements CartUIListener {
    //private final int WIDTH = 200;

    private JList<CartItem> cartList = new JList<>();
    private DefaultListModel<CartItem> model;

    private CartController cartController;

    private JPanel buttonsPanel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane();
    private JPanel totalSumPanel = new JPanel();
    private JButton remBtn;
    private JLabel total = new JLabel();
    //CartUIListener uiListener;

    public CartPanel(DefaultListModel<CartItem> model, CartController cartController){
        //this.uiListener = this;
        this.model = model;
        this.cartController = cartController;
        //cartController = new CartController(model,this);
        setBackground(Color.orange);
        setLayout(new BorderLayout());

        //initNumPad();
        initButtons();
        initScroll();



        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(buttonsPanel, BorderLayout.SOUTH);
        topPanel.add(totalSumPanel, BorderLayout.CENTER);
        topPanel.add(scrollPane, BorderLayout.NORTH);

        add(topPanel, BorderLayout.CENTER);


    }

    private void initButtons(){

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        remBtn = new JButton("Remove Item");
        remBtn.addActionListener(e -> {
            cartController.removeSelected(cartList);

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
        scrollPane = new JScrollPane(cartList);
        scrollPane.setPreferredSize(new Dimension(250,600));
        totalSumPanel.setPreferredSize(new Dimension(200,50));
        totalSumPanel.add(total);
        cartList.setFont(new Font("Arial",Font.BOLD,15));

        total.setText("Total: " + cartController.calculateCartTotal());
        total.setFont(new Font("Arial",Font.BOLD,20));


    }

    public void promptForWeight(Product product){
        String value = JOptionPane.showInputDialog(this,
                "Enter weight for " + product.getName());

        if(value != null){
            try{
                double weight = Double.parseDouble(value);
                cartController.confirmWeight(product,weight);
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Invalid weight");
            }
        }
    }
    public void updateCartTotal(BigDecimal sum){
        String formatted = String.format("%.2f", sum);
        total.setText("Total: " + formatted );
    }


    @Override
    public void requestWeightInput(Product product) {

    }

    @Override
    public void uiRequestUpdateCartTotal(BigDecimal sum) {

    }


}
