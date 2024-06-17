/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopphw;

/**
 *
 * @author atasu
 */
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String password;
    private String emailAddress;
    private String homeAddress;
    private String workAddress;
    private List<Product> productsOrdered;
    private List<Product> favoriteProducts;
    private List<CreditCard> creditCards;

    public User(String username, String name, String surname, String dateOfBirth, String password, String emailAddress, String homeAddress, String workAddress) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.emailAddress = emailAddress;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
        this.productsOrdered = new ArrayList<>();
        this.favoriteProducts = new ArrayList<>();
        this.creditCards = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public List<Product> getProductsOrdered() {
        return productsOrdered;
    }

    public void setProductsOrdered(List<Product> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }

    public List<Product> getFavoriteProducts() {
        return favoriteProducts;
    }

    public void setFavoriteProducts(List<Product> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void addCreditCard(CreditCard creditCard) {
        this.creditCards.add(creditCard);
    }

    public void orderProduct(Product product, int quantity, CreditCard creditCard) {
        if (product.reduceStock(quantity)) {
            this.productsOrdered.add(product);
            System.out.println("Product ordered successfully!");
        } else {
            System.out.println("Product stock is insufficient!");
        }
    }

    public void favoriteProduct(Product product) {
        this.favoriteProducts.add(product);
        System.out.println("Product added to favorites!");
    }
}
