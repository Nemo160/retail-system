package com.eu.retail.cashier.controller;

public class NumPadController {
    public NumPadController(){}
    public String handleNumPadInput(String current,String value) {
        if(value.contains("⌫")){
            if(!current.isEmpty()){
                return current.substring(0, current.length() - 1);
            }
            return current;
        }
        if(value.equals(".") && current.contains(".")){
            return current;
        }
        if(value.equals("Enter")){
            current.trim();
            System.out.println(current);
            return current;
        }
        if(value.equals("Clear")){
            return "";
        }
        return current + value;
    }
}
