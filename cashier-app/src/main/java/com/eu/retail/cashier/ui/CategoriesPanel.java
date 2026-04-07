package com.eu.retail.cashier.ui;

import javax.swing.*;
import java.awt.*;

public class CategoriesPanel extends JPanel {
    public CategoriesPanel(){
        setBackground(Color.YELLOW);
        setBorder(BorderFactory.createTitledBorder("Category"));
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.red);
        bottomPanel.setBackground(Color.GREEN);

        topPanel.setBorder(BorderFactory.createTitledBorder("Category"));

        add(topPanel,BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);


    }
}
