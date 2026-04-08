package com.eu.retail.cashier.controller;

public class NumPadController {
    public NumPadController(){


    }
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
            //if we are searching for something then put the itemID in the cartlist/model
            //if we are entering values such as weight then enter the weight send the value to be caluclated for the price of the item in weight.
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
