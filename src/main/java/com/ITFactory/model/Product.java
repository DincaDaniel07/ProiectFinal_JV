package com.ITFactory.model;

public class Product {
    private String productName;
    private double productPrice;
    private int productQuantity;

    public Product(String productName, double productPrice, int productQuantity) {
        this.productName = productName.toLowerCase();
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    @Override
    public String toString() {
        return STR."Product: {\{productName}, price=\{productPrice}lei, quantity=\{productQuantity}\{'}'}";
    }
}
