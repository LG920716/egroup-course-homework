package com.example.demo.entity;

public class AddressCount {
    private String address;
    private int count;


    public AddressCount(String address, int count) {
        this.address = address;
        this.count = count;
    }


    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
