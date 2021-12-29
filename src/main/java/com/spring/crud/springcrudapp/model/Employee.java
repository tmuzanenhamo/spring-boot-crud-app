package com.spring.crud.springcrudapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

// use lombok data anotation to generate the getters, setters and the constructor
@Data
// use the Entity anotation to ensure this is a JPA entity
@Entity
// use table anotation to provide a table name
@Table(name = "employees")
public class Employee {

    // use @Id annotation to denot the id and the @GeneratedValue anotation to denote the generation type 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // use @Columnn anotation to provide column details
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;

}
