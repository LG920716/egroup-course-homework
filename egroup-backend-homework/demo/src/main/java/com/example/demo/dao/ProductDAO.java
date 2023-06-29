package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductDAO {
    public void createProduct(Product product) throws Exception;

    public List<Product> readProduct() throws Exception;

    public void updateProduct(Product product) throws Exception;

    public void deleteProduct(int id) throws Exception;
}
