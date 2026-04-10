package com.eu.retail.cashier.ui.login;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private LoginPanel loginPanel;

    public LoginFrame() {

            setVisible(true);
            setTitle("Login");
            setSize(400,320);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            loginPanel = new LoginPanel();
            add(loginPanel);

    }

}
