/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopphw;

/**
 *
 * @author atasu
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ECommerceGUI {
    private User user;
    private List<Product> products;
    private DefaultListModel<String> productListModel;
    private DefaultListModel<String> creditCardListModel;
    private DefaultListModel<String> orderListModel;
    private DefaultListModel<String> favoriteListModel;

    public ECommerceGUI() {
        user = new User("jdoe", "John", "Doe", "1990-01-01", "password123", "jdoe@example.com", "123 Home St", "456 Work Ave");
        products = new ArrayList<>();
        productListModel = new DefaultListModel<>();
        creditCardListModel = new DefaultListModel<>();
        orderListModel = new DefaultListModel<>();
        favoriteListModel = new DefaultListModel<>();

        products.add(new Product("Laptop", "Silver", "Electronics", 10, 1000.0, "Yüksek performanslı laptop"));
        products.add(new Product("Phone", "Black", "Electronics", 20, 500.0, "Son model akıllı telefon"));
        products.add(new Product("Tablet", "White", "Electronics", 15, 300.0, "Yüksek çözünürlüklü tablet"));

        for (Product product : products) {
            productListModel.addElement(product.getName() + " - " + product.getCategory() + " - $" + product.getWeight() + " - Stok: " + product.getStock());
        }

        JFrame frame = new JFrame("E-Ticaret Uygulaması");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel(new CardLayout());
        frame.add(mainPanel);

        // Kredi Kartı Ekle Paneli
        JPanel addCardPanel = new JPanel();
        addCardPanel.setLayout(new GridLayout(5, 2));
        mainPanel.add(addCardPanel, "Add Credit Card");

        JLabel cardNumberLabel = new JLabel("Kart Numarası:");
        JTextField cardNumberField = new JTextField();
        JLabel cardUserLabel = new JLabel("Kart Sahibi:");
        JTextField cardUserField = new JTextField();
        JLabel securityCodeLabel = new JLabel("Güvenlik Kodu:");
        JTextField securityCodeField = new JTextField();
        JLabel expirationDateLabel = new JLabel("Son Kullanma Tarihi (AAYY):");
        JTextField expirationDateField = new JTextField();
        JButton addCardButton = new JButton("Kart Ekle");

        addCardPanel.add(cardNumberLabel);
        addCardPanel.add(cardNumberField);
        addCardPanel.add(cardUserLabel);
        addCardPanel.add(cardUserField);
        addCardPanel.add(securityCodeLabel);
        addCardPanel.add(securityCodeField);
        addCardPanel.add(expirationDateLabel);
        addCardPanel.add(expirationDateField);
        addCardPanel.add(new JLabel());
        addCardPanel.add(addCardButton);

        // Kredi Kartlarını Listele Paneli
        JPanel listCardsPanel = new JPanel();
        listCardsPanel.setLayout(new BorderLayout());
        mainPanel.add(listCardsPanel, "Kredi Kartlarını Listele");

        JList<String> creditCardList = new JList<>(creditCardListModel);
        listCardsPanel.add(new JScrollPane(creditCardList), BorderLayout.CENTER);

        // Ürünleri Listele Paneli
        JPanel listProductsPanel = new JPanel();
        listProductsPanel.setLayout(new BorderLayout());
        mainPanel.add(listProductsPanel, "Ürünleri Listele");

        JList<String> productList = new JList<>(productListModel);
        listProductsPanel.add(new JScrollPane(productList), BorderLayout.CENTER);

        // Ürün Satın Al Paneli
        JPanel purchaseProductPanel = new JPanel();
        purchaseProductPanel.setLayout(new GridLayout(3, 2));
        mainPanel.add(purchaseProductPanel, "Ürün Satın Al");

        JLabel productLabel = new JLabel("Ürün:");
        JComboBox<String> productComboBox = new JComboBox<>(convertToArray(productListModel));
        JLabel quantityLabel = new JLabel("Adet:");
        JTextField quantityField = new JTextField();
        JLabel purchaseCardNumberLabel = new JLabel("Kart Numarası:");
        JTextField purchaseCardNumberField = new JTextField();
        JButton purchaseButton = new JButton("Satın Al");

        purchaseProductPanel.add(productLabel);
        purchaseProductPanel.add(productComboBox);
        purchaseProductPanel.add(quantityLabel);
        purchaseProductPanel.add(quantityField);
        purchaseProductPanel.add(purchaseCardNumberLabel);
        purchaseProductPanel.add(purchaseButton);

        // Siparişleri Listele Paneli
        JPanel listOrdersPanel = new JPanel();
        listOrdersPanel.setLayout(new BorderLayout());
        mainPanel.add(listOrdersPanel, "Siparişleri Listele");

        JList<String> orderList = new JList<>(orderListModel);
        listOrdersPanel.add(new JScrollPane(orderList), BorderLayout.CENTER);

        // Favorilere Ürün Ekle Paneli
        JPanel addFavoritePanel = new JPanel();
        addFavoritePanel.setLayout(new GridLayout(2, 2));
        mainPanel.add(addFavoritePanel, "Favorilere Ekle");

        JLabel favoriteProductLabel = new JLabel("Ürün:");
        JComboBox<String> favoriteComboBox = new JComboBox<>(convertToArray(productListModel));
        JButton addFavoriteButton = new JButton("Favorilere Ekle");

        addFavoritePanel.add(favoriteProductLabel);
        addFavoritePanel.add(favoriteComboBox);
        addFavoritePanel.add(new JLabel());
        addFavoritePanel.add(addFavoriteButton);

        // Favori Ürünleri Listele Paneli
        JPanel listFavoritesPanel = new JPanel();
        listFavoritesPanel.setLayout(new BorderLayout());
        mainPanel.add(listFavoritesPanel, "Favorileri Listele");

        JList<String> favoriteList = new JList<>(favoriteListModel);
        listFavoritesPanel.add(new JScrollPane(favoriteList), BorderLayout.CENTER);

        // Menü Paneli
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(8, 1));
        mainPanel.add(menuPanel, "Menü");

        JButton addCardMenuButton = new JButton("Kredi Kartı Ekle");
        JButton listCardsMenuButton = new JButton("Kredi Kartlarını Listele");
        JButton listProductsMenuButton = new JButton("Ürünleri Listele");
        JButton purchaseMenuButton = new JButton("Ürün Satın Al");
        JButton listOrdersMenuButton = new JButton("Siparişlerimi Listele");
        JButton addFavoriteMenuButton = new JButton("Favorilere Ürün Ekle");
        JButton listFavoritesMenuButton = new JButton("Favori Ürünleri Listele");
        JButton exitButton = new JButton("Çıkış");

        menuPanel.add(addCardMenuButton);
        menuPanel.add(listCardsMenuButton);
        menuPanel.add(listProductsMenuButton);
        menuPanel.add(purchaseMenuButton);
        menuPanel.add(listOrdersMenuButton);
        menuPanel.add(addFavoriteMenuButton);
        menuPanel.add(listFavoritesMenuButton);
        menuPanel.add(exitButton);

        addCardMenuButton.addActionListener(e -> showCardLayout(mainPanel, "Kredi Kartı Ekle"));
        listCardsMenuButton.addActionListener(e -> showCardLayout(mainPanel, "Kredi Kartlarını Listele"));
        listProductsMenuButton.addActionListener(e -> showCardLayout(mainPanel, "Ürünleri Listele"));
        purchaseMenuButton.addActionListener(e -> showCardLayout(mainPanel, "Ürün Satın Al"));
        listOrdersMenuButton.addActionListener(e -> showCardLayout(mainPanel, "Siparişleri Listele"));
        addFavoriteMenuButton.addActionListener(e -> showCardLayout(mainPanel, "Favorilere Ekle"));
        listFavoritesMenuButton.addActionListener(e -> showCardLayout(mainPanel, "Favorileri Listele"));
        exitButton.addActionListener(e -> System.exit(0));

        addCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNumberField.getText();
                String cardUser = cardUserField.getText();
                String securityCode = securityCodeField.getText();
                String expirationDate = expirationDateField.getText();

                if (isNumeric(cardNumber) && cardNumber.length() == 16 && isNumeric(expirationDate) && expirationDate.length() == 4) {
                    CreditCard creditCard = new CreditCard(cardNumber, cardUser, securityCode, expirationDate);
                    user.addCreditCard(creditCard);
                    creditCardListModel.addElement("Card Number: " + cardNumber + ", User: " + cardUser + ", Expiration Date: " + expirationDate);
                    JOptionPane.showMessageDialog(frame, "Credit card added successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid card number or expiration date. Please try again.");
                }
            }
        });

        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = (String) productComboBox.getSelectedItem();
                int quantity = Integer.parseInt(quantityField.getText());
                String cardNumber = purchaseCardNumberField.getText();

                Product product = findProductByName(productName);
                CreditCard creditCard = findCreditCardByNumber(cardNumber);

                if (product == null) {
                    JOptionPane.showMessageDialog(frame, "Product not found.");
                } else if (creditCard == null) {
                    JOptionPane.showMessageDialog(frame, "Credit card not found.");
                } else {
                    Order order = new Order(user, product, creditCard);
                    order.processOrder(quantity);
                    orderListModel.addElement("Ordered Product: " + productName + ", Quantity: " + quantity);
                }
            }
        });

        addFavoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = (String) favoriteComboBox.getSelectedItem();
                Product product = findProductByName(productName);
                if (product != null) {
                    user.favoriteProduct(product);
                    favoriteListModel.addElement(productName);
                } else {
                    JOptionPane.showMessageDialog(frame, "Product not found.");
                }
            }
        });

        frame.setVisible(true);
        showCardLayout(mainPanel, "Menü");
    }

    private void showCardLayout(JPanel panel, String name) {
        CardLayout cl = (CardLayout) (panel.getLayout());
        cl.show(panel, name);
    }

    private boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    private CreditCard findCreditCardByNumber(String cardNumber) {
        for (CreditCard card : user.getCreditCards()) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }

    private String[] convertToArray(DefaultListModel<String> listModel) {
        String[] array = new String[listModel.getSize()];
        for (int i = 0; i < listModel.getSize(); i++) {
            array[i] = listModel.getElementAt(i);
        }
        return array;
    }
}
