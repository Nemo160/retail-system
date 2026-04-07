package com.eu.retail.core.model;

public class UnitProduct extends Product{
    private int pnu;
    private String name;
    private double price;
    private String desc;
    public UnitProduct(int pnu, String name, double price, String desc) {
        super(pnu, name, price, desc);
        this.pnu = pnu;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    @Override
    public boolean isWeighted() {
        return false;
    }

    @Override
    public double calculateTotal(double amount) {
        return getPrice()* (int) amount;
    }


    @Override
    public String toString(){
        return String.format("%s - $%.2f", name, price);
    }

}
