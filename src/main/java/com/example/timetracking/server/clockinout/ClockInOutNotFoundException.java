package com.example.timetracking.server.clockinout;

public class ClockInOutNotFoundException extends RuntimeException {
    public ClockInOutNotFoundException(String message) {
        super(message);
    }
}
