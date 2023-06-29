package com.example.demo.entity;

public class Product {
    private int id;
    private String desciption;
    private int price;
    private int stock;

    public Product(int id, String desciption, int price, int stock) {
        this.id = id;
        this.desciption = desciption;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesciption() {
        return this.desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
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
