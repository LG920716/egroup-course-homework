package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Customer;

@RestController
public class CustomerController {
    private ArrayList<Customer> customerList = new ArrayList<>();

    public CustomerController() {
        customerList.add(new Customer("Ray", "IT"));
        customerList.add(new Customer("Shu", "UX/UI"));
        customerList.add(new Customer("Ben", "IT"));
    }

    @GetMapping("/customer")
    public ArrayList<Customer> getAllCustomer() {
        if (customerList.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "無資料");
        }
        return customerList;
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") int id) {
        Customer Customer = new Customer("", "");
        try {
            Customer = customerList.get(id);
        } catch (IndexOutOfBoundsException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id: " + id + "並不存在", exception);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Customer;
    }

    @PostMapping("/customer")
    public void addOneCustomer(@RequestBody Customer customer) {
        customerList.add(customer);
    }

    @PutMapping("/Customer/{id}")
    public void editCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        try {
            customerList.add(id, customer);
        } catch (IndexOutOfBoundsException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id: " + id + "並不存在", exception);
        }
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomerById(@PathVariable("id") int id) {
        try {
            customerList.remove(id);
        } catch (IndexOutOfBoundsException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id: " + id + "並不存在", exception);
        }
    }
}
