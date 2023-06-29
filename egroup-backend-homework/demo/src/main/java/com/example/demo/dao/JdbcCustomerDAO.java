package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.AddressCount;
import com.example.demo.entity.JdbcCustomer;

@Repository
public interface JdbcCustomerDAO {
    public List<JdbcCustomer> findAll();

    public JdbcCustomer findById(long id);

    public int createJdbcCustomer(JdbcCustomer jdbcCustomer);

    public int updaJdbcCustomer(JdbcCustomer jdbcCustomer);

    public int deleteJdbcCustomer(long id);

    public List<JdbcCustomer> getNameList(String name) throws Exception;

    public List<JdbcCustomer> getWeightOrderedList() throws Exception;

    public List<JdbcCustomer> getWeightBetweenList(int lowBound, int upperBound) throws Exception;

    public List<String> getDistinctAddressList() throws Exception;

    public List<AddressCount> getGroupByAddressList() throws Exception;

    public List<String> getGroupByAddressHavingList() throws Exception;
}
