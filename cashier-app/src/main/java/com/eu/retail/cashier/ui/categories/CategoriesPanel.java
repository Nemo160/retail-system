package com.eu.retail.cashier.ui.categories;

import com.eu.retail.cashier.controller.CartController;
import com.eu.retail.cashier.controller.SearchController;
import com.eu.retail.core.model.Product;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesPanel extends JPanel {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    private JPanel categoriesCard;
    private JPanel productsCard;
    private JPanel searchCard;
    private JScrollPane scrollPane = new JScrollPane();
    private  JTextField searchField;
    private final SearchController searchController;
    private final CartController cartController;
    private JPanel resultsPanel;

    public CategoriesPanel(CartController cartController,SearchController searchController) {
        this.cartController = cartController;
        this.searchController = searchController;
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
        //contentPanel.setBorder(BorderFactory.createLineBorder(Color.red));
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
        JScrollPane scrollPane = new JScrollPane(searchField);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(100, 35));

        resultsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        resultsPanel.setBackground(Color.YELLOW);


        //NOT YET IMPLEMENTED KEYBOARD
        //SHOULD PROBABLY BE A SEPERATE CLASS WHICH COULD BE USED LATER
        JPanel keyboardPanel = new JPanel(new GridLayout(4, 8, 5, 5));


        panel.add(searchField, BorderLayout.NORTH);
        panel.add(resultsPanel, BorderLayout.CENTER);
        panel.add(keyboardPanel, BorderLayout.SOUTH);
        searchField.setFont(new Font("Arial", Font.BOLD, 18));

        //get the fields events
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSearch();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSearch();

            }
        });

        return panel;
    }
    private void showCard(String name) {
        cardLayout.show(contentPanel, name);
    }

    private void updateSearch(){
        String input = searchField.getText().toUpperCase();
        resultsPanel.removeAll();

        if(input.isEmpty()){
            resultsPanel.revalidate();
            resultsPanel.repaint();
            return;
        }

        List<Product> results = searchController.searchByCharacter(input);

        for(Product p : results){
            JButton btn = new JButton(p.getName());
            btn.setPreferredSize(new Dimension(256,80));

            btn.addActionListener(e -> {
                cartController.addProduct(p);
                searchField.setText("");
            });

            resultsPanel.add(btn);
        }
        resultsPanel.revalidate();
        resultsPanel.repaint();

    }

}
