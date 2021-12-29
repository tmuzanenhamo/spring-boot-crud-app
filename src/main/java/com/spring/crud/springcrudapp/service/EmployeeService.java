package com.spring.crud.springcrudapp.service;

import java.util.List;

import com.spring.crud.springcrudapp.model.Employee;

public interface EmployeeService {
    // Method to save an employee
    Employee saveEmployee(Employee employee);

    // Get All Employees
    List<Employee> getAllEmployees();

    // Get Employee by ID
    Employee getEmployeeByID(long id); 

}
