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

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.DepartmentCount;
import com.example.demo.entity.Employee;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDAO dao;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return dao.getAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        Employee employee = dao.getById(id);
        if (employee.getId() == -1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id: " + id + "並不存在");
        }
        return employee;
    }

    @PostMapping("/employee")
    public void addOneEmployee(@RequestBody Employee employee) {
        dao.addOneEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public void editEmployee(@PathVariable("id") int id, @RequestBody Employee employee) throws SQLException {
        // try {
        // 也可以用set add只會回傳一個布林值說他有沒有成功 但set會回傳他的值
        // employeeList.add(id, employee);
        // } catch (IndexOutOfBoundsException exception) {
        // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id: " + id + "並不存在",
        // exception);
        // }
        if (employee.getId() == 0) {
            employee.setId(id);
        }
        int result = dao.editEmployee(employee);
        if (result == 0) {
            throw new SQLException("id不存在");
        }
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable("id") int id) throws SQLException {
        int result = dao.deleteById(id);
        if (result == 0) {
            throw new SQLException("id不存在");
        }
    }

    @GetMapping("/employee/name/{name}")
    public List<Employee> findEmployeeByName(@PathVariable("name") String name) throws SQLException, Exception {
        List<Employee> customers = dao.getNameList(name);
        if (customers.size() == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "name:" + name + "並不存在");
        }
        return customers;
    }

    @PutMapping("/employee/deparement/groupby")
    public void findEmployeeGroupByDepartment() throws SQLException, Exception {
        try {
            dao.getGroupByDepartment();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @GetMapping("/employee/salary/{num1}/{num2}")
    public List<Employee> getJdbcCustomersWeightBetween(@PathVariable("num1") int num1, @PathVariable("num2") int num2) throws SQLException, Exception{
        List<Employee> customers = dao.getSalaryBetween(num1, num2);
        if (customers.size() == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "無資料");
        }
        return customers;
    }

    @GetMapping("/employee/department/distinct")
    public List<String> getEmployeeDepartmentDistinct() throws SQLException, Exception{
        List<String> customers = dao.getDistinctDepartment();
        if (customers.size() == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "無資料");
        }
        return customers;
    }

    @GetMapping("/employee/department/count")
    public List<DepartmentCount> getJdbcCustomersAddressGroupBy() throws SQLException, Exception{
        List<DepartmentCount> employee = dao.getCountDepartmentPeople();
        if (employee.size() == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "無資料");
        }
        return employee;
    }

    @GetMapping("/employee/department/onlyone")
    public List<String> getDepartmentOnlyOnePerson() throws SQLException, Exception{
        List<String> customers = dao.getDepartmentOnlyOnePerson();
        if (customers.size() == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "無資料");
        }
        return customers;
    }
}
