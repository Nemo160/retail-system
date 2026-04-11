package com.eu.retail.cashier.service;

import com.eu.retail.cashier.service.db.DatabaseManager;
import com.eu.retail.core.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCatalog {

    public Employee loginEmployee(int employeID, String password){
        String sql = """
        SELECT e.*
        FROM employees e
        JOIN employee_login l ON e.employeeID = l.employeeID
        WHERE l.employeeID = ? AND l.password = ?
        """;
        try(Connection conn = DatabaseManager.getConnection("employees");
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,employeID);
            ps.setString(2,password);

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return mapRowToEmployee(rs);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public static boolean isValidLogin(int employeeID, String password) {
        String sql = "SELECT 1 FROM employee_login WHERE employeeID = ? AND password = ?";

        try (Connection conn = DatabaseManager.getConnection("employees");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, employeeID);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public Employee findEmployeeById(int employeID){
        String sql = "SELECT * FROM employees WHERE employeeID = ?";

        try(Connection conn = DatabaseManager.getConnection("employees");
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,employeID);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return mapRowToEmployee(rs);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Employee> findEmployee(String employeeID){

        List<Employee> employees = new ArrayList<>();
        String EmployeeID = "employeeID";
        String sql = "SELECT * FROM employees WHERE employeeID = ?";
        try(Connection conn = DatabaseManager.getConnection("employees");
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,"%" + employeeID+ "%");

            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    employees.add(mapRowToEmployee(rs));
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return employees;
    }

    private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
        int  employeeID = rs.getInt("employeeID");
        String employee_firstname = rs.getString("employee_firstname");
        String employee_lastName = rs.getString("employee_lastName");
        String companyEmail = rs.getString("company_email");
        String address = rs.getString("address");
        String city = rs.getString("city");
        int zip = rs.getInt("zip");
        String phone = rs.getString("phone");
        String personalEmail = rs.getString("personal_email");
        String hireDate = rs.getString("hire_date");
        String department = rs.getString("department");


        return new Employee(employeeID,employee_firstname,
                employee_lastName,companyEmail,address,
                city,zip,phone,
                personalEmail,hireDate,department);
    }
}
