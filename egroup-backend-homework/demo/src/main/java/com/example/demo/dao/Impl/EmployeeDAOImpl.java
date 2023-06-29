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
import com.example.demo.entity.DepartmentCount;
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

    @Override
    public List<Employee> getNameList(String name) throws Exception {
        List<Employee> employee = new ArrayList<Employee>();
        String sql = "SELECT id, name, department FROM employee WHERE name LIKE ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, "%" + name + "%");
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    employee.add(getEmployee(rs));
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return employee;
    }

    @Override
    public List<Employee> getGroupByDepartment() throws Exception {
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql = "SELECT id, name, department, salary FROM employee GROUP BY department";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                employeeList.add(getEmployee(rs));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return employeeList;
    }

    @Override
    public List<Employee> getSalaryBetween(int lowBound, int upperBound) throws Exception {
        List<Employee> employee = new ArrayList<Employee>();
        String sql = "SELECT id, name, department, salary FROM employee WHERE salary BETWEEN ? and ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(lowBound, upperBound);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    employee.add(getEmployee(rs));
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }
        return employee;
    }

    @Override
    public List<String> getDistinctDepartment() throws Exception {
        List<String> employee = new ArrayList<String>();
        String sql = "SELECT DISTINCT department FROM employee";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                employee.add(rs.getString("department"));
            }
        } catch (Exception e) {
            throw e;
        }
        return employee;
    }

    @Override
    public List<DepartmentCount> getCountDepartmentPeople() throws Exception {
        List<DepartmentCount> employee = new ArrayList<DepartmentCount>();
        String sql = "SELECT department, COUNT(department) FROM employee GROUP BY department";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                employee.add(new DepartmentCount(rs.getString("sddress"), rs.getInt("COUNT(address)")));
            }
        } catch (Exception e) {
            throw e;
        }
        return employee;
    }

    @Override
    public List<String> getDepartmentOnlyOnePerson() throws Exception {
        List<String> employee = new ArrayList<String>();
        String sql = "SELECT department FROM employee GROUP BY department HAVING COUNT(department) = 1;";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                employee.add(rs.getString("department"));
            }
        } catch (Exception e) {
            throw e;
        }
        return employee;    
    }

}
