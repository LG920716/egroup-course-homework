package com.example.demo.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.SalesOrderDao;

import com.example.demo.entity.ProductSales;
import com.example.demo.entity.SalesOrder;
import com.example.demo.entity.SalesOrderItem;

@Repository
public class SalesOrderDaoImpl implements SalesOrderDao {
    @Autowired
    private DataSource Datasource;

    @Override
    public List<ProductSales> getList() throws Exception {
        List<ProductSales> customers = new ArrayList<ProductSales>();
        String sql = "SELECT product_id, name, SUN(amount) AS total FROM sale_order_item JOIN product ON product.id = sales_order_item.product_id GROUP BY product_id";
        try (Connection conn = Datasource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                customers.add(new ProductSales(result.getInt("product_id"), result.getString("name"),
                        result.getInt("total")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return customers;
    }

    @Override
    public int insert(SalesOrder order) throws Exception {
        int result = 0;
        String sql = "INSERT INTO sales_order (customer_id, order_time) values(?, ?)";
        try (Connection conn = Datasource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setInt(1, order.getCustomerId());
            stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            result = stmt.executeUpdate();
            ResultSet key = stmt.getGeneratedKeys();
            int keyValue = 0;
            if (key.first()) {
                keyValue = key.getInt(1);
            }
            System.out.println("key" + keyValue);
            System.out.println("size" + order.getItem().size());
            int items = insertItem(keyValue, order.getItem());
            System.out.println("Items inserted" + items);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    private int insertItem(int key, List<SalesOrderItem> items) throws Exception {
        int result = 0;
        String sqlItem = "INSERT INTO sales_order_item (order_id, product_id, amount, price) VALUE(?, ?, ?, ?)";
        for (SalesOrderItem item : items) {
            int price = 0;
            price = getPrice(item.getProductId());
            try (Connection conn = Datasource.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sqlItem);) {
                stmt.setInt(1, key);
                stmt.setInt(2, item.getProductId());
                stmt.setInt(3, item.getAmount());
                stmt.setInt(4, price);
                result += stmt.executeUpdate();
            } catch (Exception e) {
                throw e;
            }
        }
        return result;
    }

    private int getPrice(int id) throws Exception {
        String sqlPrice = "SELECT price FROM product WHERE id = ?";
        int price = 0;
        try (Connection conn = Datasource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sqlPrice);) {
            stmt.setInt(1, id);
            try (ResultSet resultPrice = stmt.executeQuery()) {
                if (resultPrice.next()) {
                    price = resultPrice.getInt("price");
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }
        return price;
    }

    public List<ProductSales> getTotalSalesInTimeRange(LocalDateTime startTime, LocalDateTime endTime)
            throws Exception {
        List<ProductSales> salesList = new ArrayList<>();
        String sql = "SELECT product.id AS product_id, product.name AS name, SUM(sales_order_item.amount) AS atotal " +
                "FROM sales_order_item " +
                "JOIN sales_order ON sales_order.id = sales_order_item.order_id " +
                "JOIN product ON product.id = sales_order_item.product_id " +
                "WHERE sales_order.order_time >= ? AND sales_order.order_time <= ? " +
                "GROUP BY product.id";

        try (Connection conn = Datasource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setTimestamp(1, Timestamp.valueOf(startTime));
            stmt.setTimestamp(2, Timestamp.valueOf(endTime));

            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    int productId = result.getInt("product_id");
                    String name = result.getString("name");
                    int totalSalesQuantity = result.getInt("atotal");
                    salesList.add(new ProductSales(productId, name, totalSalesQuantity));
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }

        return salesList;
    }

    @Override
    public List<SalesOrder> getStatusOfSalesOrder(int statusnum) throws Exception {
        List<SalesOrder> salesOrders = new ArrayList<SalesOrder>();
        String sql = "SELECT * FROM sales_order WHERE status = ?";

        try (Connection conn = Datasource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, statusnum);
            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    int customerId = result.getInt("customer_id");
                    salesOrders.add(new SalesOrder(customerId, statusnum));
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }

        return salesOrders;
    }

}
