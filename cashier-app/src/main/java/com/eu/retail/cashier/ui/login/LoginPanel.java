package com.eu.retail.cashier.ui.login;

import com.eu.retail.cashier.service.EmployeeCatalog;
import com.eu.retail.cashier.ui.events.LoginListener;
import com.eu.retail.core.model.Employee;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private boolean valid = false;
    private final LoginListener loginListener;
    private EmployeeCatalog employeeCatalog;

    public LoginPanel(LoginListener loginListener) {
        this.loginListener = loginListener;
        employeeCatalog = new EmployeeCatalog();
        setLayout(new BorderLayout());
        setBackground(Color.ORANGE);
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JPanel topPanel = new JPanel(new GridLayout(2,2,10,10));
        JPanel bottomPanel = new JPanel(new BorderLayout());

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();

        username.setPreferredSize(new Dimension(80, 10));
        password.setPreferredSize(new Dimension(80, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        username.setText("1");
        password.setText("wow123");


        topPanel.add(usernameLabel);
        topPanel.add(passwordLabel);
        topPanel.add(username);
        topPanel.add(password);


        JButton loginButton = getJButton(loginListener, username, password);


        bottomPanel.add(loginButton);

        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

    }

    private JButton getJButton(LoginListener loginListener, JTextField username, JPasswordField password) {
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 30));
        loginButton.addActionListener(e->{
            try{
                int id = Integer.parseInt(username.getText());
                String psw = new String(password.getPassword());

                Employee employee = employeeCatalog.loginEmployee(id,psw);

                if(employee != null){
                    System.out.print("\nVALID PASSWORD");
                    System.out.print(employee);

                    loginListener.onLoginSuccess(employee);
                }
                else{
                    System.out.print("\nNOT VALID PASSWORD");
                    JOptionPane.showMessageDialog(this,
                            "Invalid username or password",
                            "Login failed",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(LoginPanel.this, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
            }

           // valid = login(id,psw);


        });
        return loginButton;
    }

}
