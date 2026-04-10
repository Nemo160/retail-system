package com.eu.retail.core.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Employee {

    private int employeeID;
    private String employee_firstName;
    private String employee_lastName;
    private String company_email;
    private String address;
    private String city;
    private int zip;
    private String phone;
    private String personal_email;
    private String hire_date;
    private String department;

    public Employee(int employeeID, String employee_firstName, String employee_lastName,
                    String company_email, String address, String city,
                    int zip, String phone, String personal_email, String hire_date, String department) {

        this.employeeID = employeeID;
        this.employee_firstName = employee_firstName;
        this.employee_lastName = employee_lastName;
        this.company_email = company_email;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.personal_email = personal_email;
        this.hire_date = hire_date;
        this.department = department;

    }

    @Override
    public String toString() {
        return "Employee [employeeID=" + employeeID + ", employee_firstName=" + employee_firstName;
    }

}
