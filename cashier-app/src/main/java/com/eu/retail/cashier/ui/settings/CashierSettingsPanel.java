package com.eu.retail.cashier.ui.settings;

import javax.swing.*;
import java.awt.*;

public class CashierSettingsPanel extends JPanel {
    public CashierSettingsPanel(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout());
        for(int i = 0; i<4;i++){
            JButton btn = new JButton("btn: "+i);
            add(btn);
        }
    }
}
