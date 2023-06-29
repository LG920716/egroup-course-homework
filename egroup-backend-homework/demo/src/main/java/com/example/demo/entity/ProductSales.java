package com.example.demo.entity;

public class ProductSales {
    private int product_id;
    private String name;
    private int atotal;

    public ProductSales(int product_id, String name, int atotal) {
        this.product_id = product_id;
        this.name = name;
        this.atotal = atotal;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtotal() {
        return this.atotal;
    }

    public void setAtotal(int atotal) {
        this.atotal = atotal;
    }

}
