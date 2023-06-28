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

import com.example.demo.dao.JdbcCustomerDAO;
import com.example.demo.entity.JdbcCustomer;

@Repository
public class JdbcCustomerDAOImpl implements JdbcCustomerDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public JdbcCustomer findById(long id) {
        JdbcCustomer jdbcCustomers = new JdbcCustomer();
        try {
            Connection conn = dataSource.getConnection();
            String sql = "SELECT id, name, address, weight FROM customer WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // 這裡的1就是第一個位置不是0 因為要對應問號
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                jdbcCustomers = getJdbcCustomer(rs);
            } else {
                jdbcCustomers.setId(-1);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return jdbcCustomers;
    }

    @Override
    public List<JdbcCustomer> findAll() {
        List<JdbcCustomer> jdbcCustomers = new ArrayList<JdbcCustomer>();
        try {
            Connection conn = dataSource.getConnection();
            String sql = "SELECT id, name, address, weight FROM customer";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                jdbcCustomers.add(getJdbcCustomer(rs));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return jdbcCustomers;
    }

    private JdbcCustomer getJdbcCustomer(ResultSet rs) throws SQLException, Exception {
        return new JdbcCustomer(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getInt("weight"));
    }

    @Override
    public int createJdbcCustomer(JdbcCustomer jdbcCustomer) {
        int result = 0;
        try {
            Connection conn = dataSource.getConnection();
            String sql = "INSERT INTO customer (name, address, weight) VALUE(?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, jdbcCustomer.getName());
            stmt.setString(2, jdbcCustomer.getAddress());
            stmt.setInt(3, jdbcCustomer.getWeight());
            result = stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int updaJdbcCustomer(JdbcCustomer jdbcCustomer) {
        int result = 0;
        try {
            Connection conn = dataSource.getConnection();
            String sql = "UPDATE customer SET name=?, address=?, weight=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, jdbcCustomer.getName());
            stmt.setString(2, jdbcCustomer.getAddress());
            stmt.setInt(3, jdbcCustomer.getWeight());
            stmt.setLong(4, jdbcCustomer.getId());
            result = stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int deleteJdbcCustomer(long id) {
        int result = 0;
        try {
            Connection conn = dataSource.getConnection();
            String sql = "DELETE FROM customer WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            result = stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

}
