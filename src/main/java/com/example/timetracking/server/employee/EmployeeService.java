package com.example.timetracking.server.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeService {
    // this class handles tasks related to employees
    //contains methods that are handling the tasks
    //a service is used to encapsulate and implement the logic of an application
    //services are called by controller classes (classes which handle HTTP requests)
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee createEmployee(Employee employee) { return employeeRepository.save(employee); }

    @Transactional
    public Employee updateEmployee(int id, Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found.")
        );
        employeeToUpdate.setName(employee.getName());
        return employeeRepository.save(employeeToUpdate);
    }

    @Transactional
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    public Employee getEmployee(int id) { return employeeRepository.getEmployeeById(id); }


    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


}
