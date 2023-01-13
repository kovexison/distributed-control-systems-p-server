package com.example.timetracking.server.employee;

import com.example.timetracking.server.clockinout.ClockInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ClockInOutService clockInOutService;

    @PostMapping
    public Employee create(@RequestBody Employee employee)
    {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/{id}/clock-in")
    public void clockIn(@PathVariable int id) {
        clockInOutService.clockIn(id);
    }

    @PostMapping("/{id}/clock-out")
    public void clockOut(@PathVariable int id) {
        clockInOutService.clockOut(id);
    }

    @GetMapping("/{id}/work-time")
    public Duration calculateEmployeeWorkTime(@PathVariable int id) {
        return clockInOutService.calculateEmployeeWorkTime(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }
}
