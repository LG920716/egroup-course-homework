package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.JdbcCustomer;

@Repository
public interface JdbcCustomerDAO {
    public List<JdbcCustomer> findAll();

    public JdbcCustomer findById(long id);

    public int createJdbcCustomer(JdbcCustomer jdbcCustomer);

    public int updaJdbcCustomer(JdbcCustomer jdbcCustomer);

    public int deleteJdbcCustomer(long id);
}
