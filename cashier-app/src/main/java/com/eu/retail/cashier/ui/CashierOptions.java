package com.eu.retail.cashier.ui;

import javax.swing.*;
import java.awt.*;

public class CashierOptions extends JPanel {
    public CashierOptions(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout());
        for(int i = 0; i<4;i++){
            JButton btn = new JButton("btn: "+i);
            add(btn);
        }
    }
}
