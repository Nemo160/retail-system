package com.eu.retail.cashier.ui.cart;

import com.eu.retail.cashier.controller.CartController;
import com.eu.retail.cashier.model.CartItem;
import com.eu.retail.cashier.ui.CashierFrame;
import com.eu.retail.cashier.ui.events.CartUIListener;
import com.eu.retail.core.model.*;
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class CartPanel extends JPanel implements CartUIListener {
    //private final int WIDTH = 200;

    private JList<CartItem> cartList = new JList<>();
    private DefaultListModel<CartItem> model;

    private CartController cartController;

    private JPanel buttonsPanel, totalSumPanel, topPanel;
    private JScrollPane scrollPane;
    private JButton remBtn, pauseCartBtn;
    private JLabel totalLabel = new JLabel();
    private String cashierID;
    public CartPanel(DefaultListModel<CartItem> model, CartController cartController){
        this.model = model;
        this.cartController = cartController;
        cashierID = CashierFrame.getCashierID();
        cartList.setModel(model);


        setBackground(Color.orange);
        setLayout(new BorderLayout());

        initPanels();
        initButtons();

        add(topPanel, BorderLayout.CENTER);

    }
    private void initPanels(){
        topPanel = new JPanel(new BorderLayout());
        buttonsPanel = new JPanel();

        totalSumPanel = new JPanel(new BorderLayout());
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        scrollPane = new JScrollPane(cartList);
        scrollPane.setPreferredSize(new Dimension(250,600));
        totalSumPanel.setPreferredSize(new Dimension(250,50));

        cartList.setFont(new Font("Arial",Font.BOLD,15));
        totalLabel.setText("Total: " + cartController.calculateCartTotal());
        totalLabel.setFont(new Font("Arial",Font.BOLD,20));

        //CashierId & cart total
        JLabel cashierLabel = new JLabel("ID: "+ cashierID);
        cashierLabel.setForeground(new Color(153, 255, 51));
        cashierLabel.setFont(new Font("Arial",Font.BOLD,16));
        cashierLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,5,10));
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,5,10));
        leftPanel.add(totalLabel);
        rightPanel.add(cashierLabel);


        totalSumPanel.add(rightPanel,BorderLayout.EAST);
        totalSumPanel.add(leftPanel,BorderLayout.CENTER);
        topPanel.add(buttonsPanel, BorderLayout.SOUTH);
        topPanel.add(totalSumPanel, BorderLayout.CENTER);
        topPanel.add(scrollPane, BorderLayout.NORTH);
    }
    private void initButtons(){


        remBtn = new JButton("Remove Item");
        remBtn.addActionListener(e -> {
            cartController.removeSelected(cartList);

        });

        pauseCartBtn = new JButton("Pause Cart");
        JButton test3 = new JButton("Test3Btn");
        JButton test4 = new JButton("Test4Btn");



        buttonsPanel.add(remBtn);
        buttonsPanel.add(pauseCartBtn);
        buttonsPanel.add(test3);
        buttonsPanel.add(test4);
    }

    private void initScroll(){

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
        totalLabel.setText("Total: " + formatted );
    }


    @Override
    public void requestWeightInput(Product product) {

    }

    @Override
    public void uiRequestUpdateCartTotal(BigDecimal sum) {

    }


}
