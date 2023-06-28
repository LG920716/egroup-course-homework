package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO {
    public List<Employee> getAll();

    public Employee getById(int id);

    public int addOneEmployee(Employee employee);

    public int editEmployee(Employee employee);

    public int deleteById(int id);
}
