package com.example.timetracking.server.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //by extending the JpaRepository interface (provided by Spring Data JPA), this interface will have a number of
    //useful methods for performing CRUD operations on the employee data:
    //findAll(), findById(), save(), deleteByTd(), etc.
    //if I add a method to this interface, it will be implemented by the JPARepository
    //the method name has to  follow a specific naming convention that tells Spring JPA to create an implementation
    //of methods

    //additional methods specific to the Employee entity

    List<Employee> findByName(String name);
    List<Employee> findByClockInTimeBetween(LocalDateTime start, LocalDateTime end);

    Employee getEmployeeById(int id);
}
