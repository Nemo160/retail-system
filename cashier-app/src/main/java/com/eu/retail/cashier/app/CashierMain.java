package com.eu.retail.cashier.app;

import com.eu.retail.cashier.ui.*;
import javax.swing.SwingUtilities;

public class CashierMain {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            CashierFrame frame = new CashierFrame();
            frame.setVisible(true);
        });

    }
}
