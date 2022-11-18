package com.example.timetracking.server.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
}