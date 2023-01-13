package com.example.timetracking.server.employee;

import lombok.*;
import net.bytebuddy.asm.Advice;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "hourly_rate")
    private int hourlyRate;

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private Date enrollDate;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "position")
    private String position;

    @Column(name = "image_url")
    private String imageURL;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return id != null && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
