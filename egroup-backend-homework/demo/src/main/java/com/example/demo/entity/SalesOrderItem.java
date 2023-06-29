package com.example.demo.entity;

public class SalesOrderItem {
    private int id;
    private int orderId;
    private int productId;
    private int price;
    private int amount;
    

    public SalesOrderItem(int id, int orderId, int productId, int price, int amount) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
