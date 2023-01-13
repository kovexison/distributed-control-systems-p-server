package com.example.timetracking.server.clockinout;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClockInOutRepository extends JpaRepository<ClockInOut, Integer> {
    ClockInOut findByEmployeeId(int id);
}
