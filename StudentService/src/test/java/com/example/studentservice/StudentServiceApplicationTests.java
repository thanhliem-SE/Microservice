package com.example.studentservice;

import com.example.studentservice.entity.Student;
import com.example.studentservice.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceApplicationTests {

     @Autowired
     private StudentService studentService;

    @Test
    void contextLoads() {
        Student student = new Student();
        student.setStudentName("james Bond");
        student.setFacultyId(2);
        System.out.println(studentService.updateUser(student, 2));
    }

}
