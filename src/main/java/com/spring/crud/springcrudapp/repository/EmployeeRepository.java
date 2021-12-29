package com.spring.crud.springcrudapp.repository;

import com.spring.crud.springcrudapp.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

// The repository gets CRUD methods for the employee JPA entity
// JpaRepository internaly provides the @Repository ad @Transactional Anotation
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
