package com.eu.retail.cashier.ui.login;

import com.eu.retail.cashier.ui.events.LoginListener;
import com.eu.retail.core.model.Employee;

import javax.swing.*;
import java.awt.*;

public class LoginDialog extends JDialog{
    private Employee loggedInEmployee;

    public LoginDialog(Frame parent) {
        super(parent, "Login", true);

       // setSize(400,320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new LoginPanel(employee -> {
            loggedInEmployee = employee;
            dispose();
        }));
        pack();
        setLocationRelativeTo(parent);

    }

    public Employee getLoggedInEmployee() {
        return loggedInEmployee;
    }

}
