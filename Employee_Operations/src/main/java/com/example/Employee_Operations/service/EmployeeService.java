package com.example.Employee_Operations.service;

import com.example.Employee_Operations.exception.EmployeeNotFoundException;
import com.example.Employee_Operations.model.Employee;
import com.example.Employee_Operations.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee)
    {
         return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).orElse(null);
        if(employee==null)
        {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(long id,Employee employee) {
        Employee old=employeeRepository.findById(id).orElse(null);
        if(old!=null)
        {
            old.setFirst_name(employee.first_name);
            old.setLast_name(employee.last_name);
            old.setDepartment(employee.getDepartment());
            old.setSalary(employee.salary);
            employeeRepository.save(old);
        }
        return employeeRepository.findById(id).orElse(null);

    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
