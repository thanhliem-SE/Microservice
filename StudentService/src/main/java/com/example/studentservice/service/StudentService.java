package com.example.studentservice.service;

import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.entity.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public Student saveUser(Student student);
    public Student updateUser(Student student, int id);
    public void deleteUser(int id);
    public ResponseTemplateVO getUserWithDepartment(int id);
    public List<ResponseTemplateVO> getListUserWithDepartment();
}
