package com.example.timetracking.server.clockinout;

import com.example.timetracking.server.employee.Employee;
import com.example.timetracking.server.employee.EmployeeNotFoundException;
import com.example.timetracking.server.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ClockInOutService {
    @Autowired
    private ClockInOutRepository clockInOutRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void clockIn(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        ClockInOut clockInOut = clockInOutRepository.findByEmployeeId(id);
        if (clockInOut == null) {
            clockInOut = new ClockInOut();
            clockInOut.setEmployee(employee);
        }
        clockInOut.setClockInTime(LocalDateTime.now());
        clockInOutRepository.save(clockInOut);
    }

    @Transactional
    public void clockOut(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found.")
        );
        ClockInOut clockInOut = clockInOutRepository.findByEmployeeId(id);
        if(clockInOut == null) {
            throw new ClockInOutNotFoundException("Clock in/out not found for employee with id: " + id);
        }
        clockInOut.setClockOutTime(LocalDateTime.now());
        clockInOutRepository.save(clockInOut);
    }

    public Duration calculateEmployeeWorkTime(int id) {
        ClockInOut clockInOut = clockInOutRepository.findByEmployeeId(id);
        if (clockInOut == null) {
            throw new ClockInOutNotFoundException("Clock in/out not found for employee with id: " + id);
        }
        LocalDateTime clockInTime = clockInOut.getClockInTime();
        LocalDateTime clockOutTime = clockInOut.getClockOutTime();
        if (clockInTime == null || clockOutTime == null) {
            throw new IllegalStateException("Employee has not clocked in or out yet");
        }
        return Duration.between(clockInTime, clockOutTime);
    }
}
