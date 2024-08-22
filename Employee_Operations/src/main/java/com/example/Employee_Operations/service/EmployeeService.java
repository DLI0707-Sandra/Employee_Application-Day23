package com.example.Employee_Operations.service;

import com.example.Employee_Operations.exception.EmployeeNotFoundException;
import com.example.Employee_Operations.model.Employee;
import com.example.Employee_Operations.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    @Override
    public void addMultiple(String file_location) {
        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(file_location)))
        {
            bufferedReader.readLine();
            String line;
            int i;
            while ((line = bufferedReader.readLine()) != null)
            {
                i=0;
                String[] data = line.split(",");
                Employee new_employee=new Employee();
                new_employee.setFirst_name(data[i++]);
                new_employee.setLast_name(data[i++]);
                new_employee.setDepartment(data[i++]);
                String salary=data[i++].trim();
                Long new_salary=Long.parseLong(salary);
                new_employee.setSalary(new_salary);
                employeeRepository.save(new_employee);
            }
        }catch (IOException e)
        {
            System.out.println("File not found Exception");
        }
    }

}
