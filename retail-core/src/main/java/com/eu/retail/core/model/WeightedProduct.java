package com.eu.retail.core.model;

public class WeightedProduct extends Product{
    private int PNU;
    private String name;
    private double price;
    private String desc;
    public WeightedProduct(int PNU, String name, double price, String desc) {
        super(PNU, name, price, desc);
        this.PNU = PNU;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    @Override
    public double calculateTotal(double amount) {
        return getPrice()*amount;
    }

    @Override
    public String toString(){
        return String.format("%s - $%.2f/kg", name, price);
    }
}
