package com.example.demo.entity;

public class Product {
    private int id;
    private String description;
    private int price;
    private int stock;

    public Product(){};

    public Product(int id, String description, int price, int stock) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
