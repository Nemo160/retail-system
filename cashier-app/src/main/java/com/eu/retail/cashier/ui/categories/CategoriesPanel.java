package com.eu.retail.cashier.ui.categories;

import javax.swing.*;
import java.awt.*;

public class CategoriesPanel extends JPanel {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    private JPanel categoriesCard;
    private JPanel productsCard;
    private JPanel searchCard;
    private JScrollPane scrollPane = new JScrollPane();


    public CategoriesPanel(){
        setBackground(Color.YELLOW);
        setLayout(new BorderLayout());

        initTopPanel();
        initCards();


    }

    private void initTopPanel(){
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton backBtn = new JButton("Back");
        JButton searchBtn = new JButton("Search");
        JLabel titleLabel = new JLabel("Categories");

        backBtn.addActionListener(e->showCard("categories"));
        searchBtn.addActionListener(e->showCard("search"));

        topPanel.add(backBtn);
        topPanel.add(searchBtn);
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

    }
    private void initCards(){
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        categoriesCard = buildCategoriesCard();
        productsCard = buildProductsCard();
        searchCard = buildSearchCard();

        contentPanel.add(categoriesCard, "categories");
        contentPanel.add(productsCard, "products");
        contentPanel.add(searchCard, "search");

        add(contentPanel, BorderLayout.CENTER);

        cardLayout.show(contentPanel, "categories");
    }

    private JPanel buildCategoriesCard() {
        JPanel panel = new JPanel(new GridLayout(0, 4, 10, 10));
        for (int i = 0; i < 12; i++) {
            JButton btn = new JButton("Category" + i);
            btn.addActionListener(e -> {
                showCard("products");
            });
            panel.add(btn);
        }
        return panel;
    }

    private JPanel buildProductsCard(){
        JPanel panel = new JPanel(new GridLayout(0, 4, 10, 10));

        for (int i = 0; i < 20; i++) {
            JButton btn = new JButton("Product " + i);
            panel.add(btn);
        }

        return panel;
    }
    private JPanel buildSearchCard(){
        JPanel panel = new JPanel(new BorderLayout());

        JTextField searchField = new JTextField();
        JPanel resultsPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        JPanel keyboardPanel = new JPanel(new GridLayout(4, 8, 5, 5));

        panel.add(searchField, BorderLayout.NORTH);
        panel.add(new JScrollPane(resultsPanel), BorderLayout.CENTER);
        panel.add(keyboardPanel, BorderLayout.SOUTH);

        return panel;
    }
    private void showCard(String name) {
        cardLayout.show(contentPanel, name);
    }

}
