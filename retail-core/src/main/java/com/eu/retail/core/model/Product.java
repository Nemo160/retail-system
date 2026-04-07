package com.eu.retail.core.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
public abstract class Product {
    private int PNU;
    private String name;
    private double price;
    private String desc;


    public Product(int PNU, String name, double price, String desc){
        this.PNU = PNU;
        this.name = name;
        this.price = price;
        this.desc = desc;


    }

    public abstract double calculateTotal(double amount);

    /*
    @Override
    public String toString() {
        if(pricingType == PricingType.PER_KG){
            return String.format("%s - $%.2f/kg", name, price);
        }
        else{
            return String.format("%s - $%.2f", name, price);
        }
    }
    */
}
