package com.example.Employee_Operations.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "firstName")
    public String first_name;

    @Column(name = "lastName")
    public String last_name;

    @Column(name = "department")
    public String department;

    @Column(name="salary")
    public Long salary;
}
