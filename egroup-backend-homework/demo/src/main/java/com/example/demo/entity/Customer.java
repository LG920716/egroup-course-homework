package com.example.demo.entity;

public class Customer {
    private String name;
    private String age;

    public Customer(String name, String age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(String age){
        this.age = age;
    }

    public String getAge(){
        return age;
    }
}
