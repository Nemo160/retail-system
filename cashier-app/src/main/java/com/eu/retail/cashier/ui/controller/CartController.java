package com.eu.retail.cashier.ui.controller;

import com.eu.retail.cashier.ui.CartUIListener;
import com.eu.retail.cashier.ui.model.CartItem;
import com.eu.retail.core.model.Product;

import javax.swing.*;
import java.math.BigDecimal;

//This class controlls every logic for the instance of the cart
//Logic: adding/removing item from cart, calculating sum of cart
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
            uiListener.uiRequestUpdateCartTotal(calculateCartTotal());
        }
    }

    public void addProduct(Product product){
        if(product == null){ return; }
        if(product.isWeighted()){
            uiListener.requestWeightInput(product);
            System.out.println("ADDING PRODUCT: "+product);
            updateCartTotal(calculateCartTotal());

        }

        else{ //UNIT PRODUCT
            for(int i = 0; i < model.size(); i++) {
                CartItem item = model.getElementAt(i);

                if(item.getProduct().equals(product)) {
                    item.setQuantity(item.getQuantity() + 1);
                    model.set(i, item); //refresh
                    System.out.println(model);
                    updateCartTotal(calculateCartTotal());
                    return;

                }
            }
            CartItem item = new CartItem(product, 1);
            model.addElement(item);
            updateCartTotal(calculateCartTotal());

        }

    }
    public void confirmWeight(Product product, double weight){
        CartItem item = new CartItem(product, weight);
        model.addElement(item);
    }

    public BigDecimal calculateCartTotal(){
        BigDecimal sum = new BigDecimal("0");
        for(int i = 0; i < model.size();i++){
            sum = sum.add(model.getElementAt(i).getTotalPrice());
        }
        return sum;
    }

    public void updateCartTotal(BigDecimal sum){
        uiListener.uiRequestUpdateCartTotal(sum);
    }


}
