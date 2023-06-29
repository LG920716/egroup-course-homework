package com.example.demo.entity;

import java.util.List;

public class SalesOrder {
    private int id;
    private int customerId;
    private List<SalesOrderItem> item;
    private int status;

    public SalesOrder(int id, int customerId, List<SalesOrderItem> item, int status) {
        this.id = id;
        this.customerId = customerId;
        this.item = item;
        this.status = status;
    }

    public SalesOrder(int id, int status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<SalesOrderItem> getItem() {
        return this.item;
    }

    public void setItem(List<SalesOrderItem> item) {
        this.item = item;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

}
