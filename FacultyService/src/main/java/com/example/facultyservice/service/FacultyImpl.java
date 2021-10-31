package com.example.facultyservice.service;

import com.example.facultyservice.entity.Faculty;
import com.example.facultyservice.repository.FacultyRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FacultyImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    @Retry(name = "basic")
    public Faculty getFaculty(int id) {
        log.info("IN GET FACULTY BY ID");
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
