package com.example.Employee_Operations.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "firstName")
    public String first_name;

    @Column(name = "lastName")
    public String last_name;

    @Column(name = "department")
    public String department;

    @NotNull(message = "Salary should not be empty!")
    @Min(value = 10000, message = "Salary must Be greater than 10,000!")
    @Max(value = 500000, message = "Salary must be less than 5,00,000!")
    @Column(name="salary")
    public Long salary;
}
