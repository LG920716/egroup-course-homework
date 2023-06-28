package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dao.JdbcCustomerDAO;
import com.example.demo.entity.JdbcCustomer;

@RestController
public class JdbcCustomerController {

    @Autowired
    JdbcCustomerDAO dao;

    @GetMapping("/customers")
    public List<JdbcCustomer> getAllJdbcCustomers() throws SQLException, Exception {
        return dao.findAll();
    }

    @GetMapping("/customers/{id}")
    public JdbcCustomer findJdbeCustomerById(@PathVariable("id") long id) throws SQLException {
        JdbcCustomer jdbcCustomer = dao.findById(id);
        if (jdbcCustomer.getId() == -1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id: " + id + "並不存在");
        }
        return jdbcCustomer;
    }

    @PostMapping("/customer")
    public void createJdbcCustomer(@RequestBody JdbcCustomer jdbcCustomer) {
        dao.createJdbcCustomer(jdbcCustomer);
    }

    @PutMapping("/customer/{id}")
    public void updateJdbcCustomer(@RequestBody JdbcCustomer jdbcCustomer, @PathVariable("id") long id)
            throws SQLException {
        if (jdbcCustomer.getId() == 0) {
            jdbcCustomer.setId(id);
        }
        int result = dao.updaJdbcCustomer(jdbcCustomer);
        if (result == 0) {
            throw new SQLException("id不存在");
        }
    }

    @DeleteMapping("/customer/{id}")
    public void deleteJdbcCustomer(@PathVariable("id") long id) throws SQLException {
        int result = dao.deleteJdbcCustomer(id);
        if (result == 0) {
            throw new SQLException("id不存在");
        }
    }
}
