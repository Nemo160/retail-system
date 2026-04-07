package com.eu.retail.cashier.ui.controller;

import com.eu.retail.cashier.ui.CartUIListener;
import com.eu.retail.cashier.ui.model.CartItem;
import com.eu.retail.core.model.Product;

import javax.swing.*;

public class CartController {
    private DefaultListModel<CartItem> model;
    private CartUIListener uiListener;
    public CartController(DefaultListModel<CartItem> model, CartUIListener uiListener){
        this.model = model;
        this.uiListener = uiListener;

    }

    public void removeSelected(JList<CartItem> list){
        int i = list.getSelectedIndex();
        if(i != -1){
            model.remove(i);
        }
    }

    public void addProduct(Product product){
        if(product == null){ return; }
        if(product.isWeighted()){
            uiListener.requestWeightInput(product);
            System.out.println("ADDING PRODUCT: "+product);
        }
        else{
            for (int i = 0; i < model.size(); i++) {
                CartItem item = model.getElementAt(i);

                if (item.getProduct().equals(product)) {
                    item.setQuantity(item.getQuantity() + 1);
                    return;
                }
                model.set(i, item); //refresh
            }
            CartItem item = new CartItem(product, 1);
            model.addElement(item);

        }

    }
    public void confirmWeight(Product product, double weight){
        CartItem item = new CartItem(product, weight);
        model.addElement(item);
    }


}
