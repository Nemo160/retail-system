package com.eu.retail.core.model;

public class WeightedProduct extends Product{
    private int pnu;
    private String name;
    private double price;
    private String desc;
    public WeightedProduct(int pnu, String name, double price, String desc) {
        super(pnu, name, price, desc);
        this.pnu = pnu;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    @Override
    public boolean isWeighted() {
        return true;
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
