package com.example.demo.entity;

public class JdbcCustomer {
    private long id;
    private String name;
    private String address;
    private int weight;

    public JdbcCustomer() {
    }

    public JdbcCustomer(long id, String name, String address, int weight) throws Exception {
        this.id = id;
        this.name = name;
        this.address = address;
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new Exception("體重必須大於0");
        }
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
