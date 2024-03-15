package com.newt.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_tb")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, updatable = false, nullable = false) 
    private UUID id;

    @Column(name = "company_name", unique = false, updatable = true, nullable = false)
    private String name;

    @Column(name = "location", unique = false, updatable = true, nullable = true)
    private String location;

    @OneToMany()
    private List<Employee> employees;



}
