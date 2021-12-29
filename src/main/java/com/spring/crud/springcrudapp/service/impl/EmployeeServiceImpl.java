package com.spring.crud.springcrudapp.service.impl;

import java.util.List;
import java.util.Optional;

import com.spring.crud.springcrudapp.exception.ResourceNotFoundException;
import com.spring.crud.springcrudapp.model.Employee;
import com.spring.crud.springcrudapp.repository.EmployeeRepository;
import com.spring.crud.springcrudapp.service.EmployeeService;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Dependancy injection, use constructor based injecttion when theer are
    // mandatory params and setter based injection when there are optional params
    private EmployeeRepository employeeRepository;

    // No need to add the @Autrowired anotation as it is provided by springboot
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByID(long id) {
        // find by id returns optional so use optional from java.util
        // Optional<Employee> employee = employeeRepository.findById(id);
        // if (employee.isPresent()) {
        // return employee.get();
        // } else {
        // throw new ResourceNotFoundException("Employee", "ID", id);
        // }

        // use lambda expression to implement the above logic
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

    }

}
