package com.example.demo.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    DataSource dataSource;

    @Override
    public void createProduct(Product product) throws Exception {
        String sql = "INSERT INTO product (description, price, stock) VALUE(?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, product.getDescription());
            stmt.setInt(2, product.getPrice());
            stmt.setInt(3, product.getStock());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Product> readProduct() throws Exception {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT id, description, price, stock FROM product";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                productList.add(getProduct(rs));
            }
            conn.close();
        } catch (Exception e) {
            throw e;
        }
        return productList;
    }

    private Product getProduct(ResultSet rs) throws SQLException, Exception {
        return new Product(
                rs.getInt("id"),
                rs.getString("description"),
                rs.getInt("price"),
                rs.getInt("stock"));
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        try {
            Connection conn = dataSource.getConnection();
            String sql = "UPDATE product SET description=?, price=?, stock=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getDescription());
            stmt.setInt(2, product.getPrice());
            stmt.setInt(3, product.getStock());
            stmt.setInt(4, product.getId());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteProduct(int id) throws Exception {
        String sql = "DELETE FROM product WHERE id=?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

}
