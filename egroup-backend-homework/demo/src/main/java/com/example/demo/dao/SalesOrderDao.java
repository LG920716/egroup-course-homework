package com.example.demo.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.entity.ProductSales;
import com.example.demo.entity.SalesOrder;

public interface SalesOrderDao {
    public int insert(SalesOrder order) throws Exception;

    public List<ProductSales> getList() throws Exception;

    public List<ProductSales> getTotalSalesInTimeRange(LocalDateTime startTime, LocalDateTime endTime) throws Exception;

    public List<SalesOrder> getStatusOfSalesOrder(int statusnum) throws Exception;
}
