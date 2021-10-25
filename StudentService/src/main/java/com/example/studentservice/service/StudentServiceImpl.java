package com.example.studentservice.service;

import com.example.studentservice.VO.Deparment;
import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.entity.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Student saveUser(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateUser(Student student, int id) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public void deleteUser(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(int id) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        Student student = studentRepository.findById(id).get();
        responseTemplateVO.setStudent(student);
        Deparment deparment = restTemplate.getForObject("http://localhost:8080/faculties/" + student.getFacultyId(),
                Deparment.class);
        responseTemplateVO.setDeparment(deparment);
        return responseTemplateVO;
    }

    @Override
    public List<ResponseTemplateVO> getListUserWithDepartment() {
        ArrayList<ResponseTemplateVO> listResponseTemplateVO = new ArrayList<>();
        ArrayList<Student> listStudent = (ArrayList<Student>) studentRepository.findAll();
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        for (int i = 0; i < listStudent.size(); i++) {
            responseTemplateVO.setStudent(listStudent.get(i));
            responseTemplateVO.setDeparment(restTemplate.getForObject("http://localhost:8080/faculties/" + listStudent.get(i).getFacultyId(), Deparment.class));
            listResponseTemplateVO.add(responseTemplateVO);
        }
        return listResponseTemplateVO;
    }
}
