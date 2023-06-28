package com.example.demo.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            Connection conn = dataSource.getConnection();
            String sql = "SELECT id, name, department FROM employee";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employeeList.add(getEmployee(rs));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return employeeList;
    }

    private Employee getEmployee(ResultSet rs) throws SQLException, Exception {
        return new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("department"));
    }

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        try {
            Connection conn = dataSource.getConnection();
            String sql = "SELECT id, name, department FROM employee WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                employee = getEmployee(rs);
            } else {
                employee.setId(-1);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return employee;
    }

    @Override
    public int addOneEmployee(Employee employee) {
        int result = 0;
        try {
            Connection conn = dataSource.getConnection();
            String sql = "INSERT INTO employee (name, department) VALUE(?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getDepartment());
            result = stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int editEmployee(Employee employee) {
        int result = 0;
        try {
            Connection conn = dataSource.getConnection();
            String sql = "UPDATE customer SET name=?, department=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getDepartment());
            stmt.setLong(3, employee.getId());
            result = stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int deleteById(int id) {
        int result = 0;
        try {
            Connection conn = dataSource.getConnection();
            String sql = "DELETE FROM employee WHERE id=?";
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
