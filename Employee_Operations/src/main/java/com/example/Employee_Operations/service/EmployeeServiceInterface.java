package com.example.Employee_Operations.service;

import com.example.Employee_Operations.model.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    public Employee addEmployee(Employee employee);
    public Employee getEmployeeById(Long id);
    public List<Employee> getAllEmployees();
    public Employee updateEmployee(long id,Employee employee);
    public void deleteEmployee(Long id);
}
