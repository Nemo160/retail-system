package com.eu.retail.cashier.ui;

import javax.swing.*;
import java.awt.*;

public class CashierOptionsPanel extends JPanel {
    public CashierOptionsPanel(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout());
        for(int i = 0; i<4;i++){
            JButton btn = new JButton("btn: "+i);
            add(btn);
        }
    }
}
