package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.DepartmentCount;
import com.example.demo.entity.Employee;

public interface EmployeeDAO {
    public List<Employee> getAll();

    public Employee getById(int id);

    public int addOneEmployee(Employee employee);

    public int editEmployee(Employee employee);

    public int deleteById(int id);

    public List<Employee> getNameList(String name) throws Exception;

    public List<Employee> getGroupByDepartment() throws Exception;

    public List<Employee> getSalaryBetween(int lowBound, int upperBound) throws Exception;

    public List<String> getDistinctDepartment() throws Exception;

    public List<DepartmentCount> getCountDepartmentPeople() throws Exception;

    public List<String> getDepartmentOnlyOnePerson() throws Exception;
}
