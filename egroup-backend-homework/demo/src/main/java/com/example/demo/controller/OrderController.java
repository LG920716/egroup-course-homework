package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SalesOrderDao;
import com.example.demo.entity.SalesOrder;
import com.example.demo.entity.ProductSales;

@RestController
public class OrderController {

    @Autowired
    SalesOrderDao dao;

    @PostMapping("/orders")
    public void insert(@RequestBody SalesOrder order) throws Exception{
        System.out.println(dao.insert(order));
    }

    @GetMapping("/orders")
    public List<ProductSales> getList() throws Exception{
        return dao.getList();
    }

    @GetMapping("/product/sales")
    public List<ProductSales> getTotalSalesInTimeRange(LocalDateTime startTime, LocalDateTime endTime) throws Exception{
        return dao.getTotalSalesInTimeRange(startTime, endTime);
    }

    @GetMapping("/order/status/{statusnum}")
    public List<SalesOrder> getStatusOfSalesOrder(int statusnum) throws Exception{
        return dao.getStatusOfSalesOrder(statusnum);
    }
}
