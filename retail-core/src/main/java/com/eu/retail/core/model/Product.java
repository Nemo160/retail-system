package com.eu.retail.core.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
public class Product {
    public enum PricingType{
        UNIT,
        PER_KG
    }
    private String name;
    private double price;
    private String desc;
    private PricingType pricingType;
    public Product(String name, double price, String desc, PricingType pricingType){
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.pricingType = pricingType;

    }
    @Override
    public String toString(){
        if(pricingType == PricingType.PER_KG){
            return name + " - $" + price + "/kg";
        }
        else{
            return name + " - $" + price;
        }

    }
}
