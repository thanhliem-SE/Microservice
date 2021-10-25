package com.example.facultyservice.service;

import com.example.facultyservice.entity.Faculty;
import com.example.facultyservice.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty getFaculty(int id) {
        return facultyRepository.findById(id).get();
    }

    @Override
    public List<Faculty> getListFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public void addFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    public void updateFaculty(int id, Faculty faculty) {
        faculty.setId(id);
        facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(int id) {
        facultyRepository.deleteById(id);
    }
}
