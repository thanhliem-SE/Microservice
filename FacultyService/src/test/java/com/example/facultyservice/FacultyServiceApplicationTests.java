package com.example.facultyservice;

import com.example.facultyservice.service.FacultyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class FacultyServiceApplicationTests {

    @Autowired
    FacultyService facultyService;

    @Test
    void contextLoads() {
        for(int i=0; i<10; i++){
            facultyService.getFaculty(1);
        }
    }

}
