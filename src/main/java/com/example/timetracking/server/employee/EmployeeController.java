package com.example.timetracking.server.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody Employee employee)
    {
        return employeeService.create(employee);
    }


    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.findAllEmployees();
    }
}
