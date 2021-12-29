package com.spring.crud.springcrudapp.service.impl;

import java.util.List;

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

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // check if the employee with the given id exists

        Employee existingEmploye = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        // update the exising employee

        existingEmploye.setFirstName(employee.getFirstName());
        existingEmploye.setLastName(employee.getLastName());
        existingEmploye.setEmail(employee.getEmail());
        employeeRepository.save(existingEmploye);

        return existingEmploye;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employeeRepository.deleteById(id);      
    }

}
