package com.example.timetracking;

import com.example.timetracking.server.ServerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = ServerApplication.class)
public class ServerApplicationTests {

    @Test
    void contextLoads() {
    }
}
