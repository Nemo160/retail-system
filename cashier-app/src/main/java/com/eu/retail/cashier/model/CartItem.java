package com.eu.retail.cashier.model;

import com.eu.retail.core.model.Product;

import java.math.BigDecimal;

public class CartItem {
    private Product product;
    private int quantity;
    private double weight;

    //Unit constructor
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    //Weighted constructor
    public CartItem(Product product, double weight) {
        this.product = product;
        this.weight = weight;
        this.quantity = 0;
    }

    public int getQuantity() {
        return quantity;
    }
    public Product getProduct(){
        return product;
    }
    public void setQuantity(int q){
        this.quantity = q;
    }

    public double getWeight() {
        return weight;
    }

    public BigDecimal getTotalPrice() {
        if(product.isWeighted()){
            return product.calculateTotal(weight);
        }
        else{
            return product.calculateTotal(quantity);
        }
    }

    @Override
    public String toString() {
        if(product.isWeighted()){
            return String.format(
                    "%s (%.2f kg × %.2fKr/kg) - %.2f",
                    product.getName(),
                    weight,
                    product.getPrice(),
                    getTotalPrice()
            );
        }
        else{
            return String.format(
                    "%s (%d × %.2fKr) - %.2f",
                    product.getName(),
                    quantity,
                    product.getPrice(),
                    getTotalPrice()
            );
        }
    }
}
