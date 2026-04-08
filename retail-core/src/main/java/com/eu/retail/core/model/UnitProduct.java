package com.eu.retail.core.model;

import java.math.BigDecimal;

public class UnitProduct extends Product{
    private int pnu;
    private String name;
    private BigDecimal price;
    private String desc;
    public UnitProduct(int pnu, String name, BigDecimal price, String desc) {
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
    public BigDecimal calculateTotal(double a) {
        BigDecimal amount = new BigDecimal(a);
        return amount.multiply(getPrice());
    }



    @Override
    public String toString(){
        return String.format("%s - $%.2f", name, price);
    }

}
