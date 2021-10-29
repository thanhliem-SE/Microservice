package com.example.studentservice.controller;

import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.entity.Student;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @Value("${student-service-greeting}")
    private String welcome;

    @GetMapping("/welcome")
    public String getWelcome(){return welcome;}

    @GetMapping("/")
    public List<ResponseTemplateVO> getListStudentWithDepartment() {
        return studentService.getListUserWithDepartment();
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getStudentWithDepartment(@PathVariable("id") int id) {
        return studentService.getUserWithDepartment(id);
    }

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student) {
            return studentService.saveUser(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") int id,@RequestBody Student student) {
        System.out.println("============" + student + "================");
        return studentService.updateUser(student, id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        try {
            studentService.deleteUser(id);
            return "Success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
