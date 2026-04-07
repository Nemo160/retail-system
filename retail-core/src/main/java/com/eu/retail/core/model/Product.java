package com.eu.retail.core.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public abstract class Product {
    private int pnu;
    private String name;
    private double price;
    private String desc;


    public Product(int pnu, String name, double price, String desc){
        this.pnu = pnu;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }
    public abstract boolean isWeighted();

    public abstract double calculateTotal(double amount);

}
