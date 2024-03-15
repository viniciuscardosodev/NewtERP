package com.newt.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_tb")
public class Employee {

    @Id
    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @Column(name = "name", nullable = false, length = 150, updatable = true)
    private String name;

    @Column(name = "salary", nullable = false, updatable = true)
    private Double salary;
    
    @ManyToOne()
    @JoinColumn(name = "fk_company_id")
    private Company empresa;

    public Employee() {
    }

    public Employee(User user, String name, Double salary) {
        this.user = user;
        this.name = name;
        this.salary = salary;
    }

    
}
