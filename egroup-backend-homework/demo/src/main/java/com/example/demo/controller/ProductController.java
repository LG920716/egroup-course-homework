package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.Product;

@RestController
public class ProductController {

    @Autowired
    ProductDAO dao;

    @PostMapping("/products")
    public void createProduct(Product product) throws SQLException, Exception{
        dao.createProduct(product);
    }

    @GetMapping("/products")
    public List<Product> readProduct() throws SQLException, Exception{
        List<Product> products = dao.readProduct();
        if(products.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "無資料");
        }
        return products;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(int id) throws SQLException, Exception{
        dao.deleteProduct(id);
    }
}
