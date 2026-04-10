package com.eu.retail.core.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
public abstract class Product {
    private int pnu;
    private String name;
    private BigDecimal price;
    private String desc;


    public Product(int pnu, String name, BigDecimal price, String desc){
        this.pnu = pnu;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public abstract boolean isWeighted();

    public abstract BigDecimal calculateTotal(double amount);

}
