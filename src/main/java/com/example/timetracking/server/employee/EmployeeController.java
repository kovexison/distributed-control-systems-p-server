package com.example.timetracking.server.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Employee create(@RequestBody Employee employee)
    {
        return employeeService.create(employee);
    }


    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.findAllEmployees();
    }
}
