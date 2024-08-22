package com.example.Employee_Operations.controller;

import com.example.Employee_Operations.model.Employee;
import com.example.Employee_Operations.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@Valid @RequestBody Employee employee)
    {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable long id)
    {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/all")
    public List<Employee> displayAll()
    {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable long id)
    {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable long id,@Valid @RequestBody Employee employee)
    {
        return employeeService.updateEmployee(id,employee);
    }

    @PostMapping("/addwithCSV")
    public void addMultiple(@RequestBody String file_location)
    {
         employeeService.addMultiple(file_location);
    }

}
