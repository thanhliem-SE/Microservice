package com.example.facultyservice.service;

import com.example.facultyservice.entity.Faculty;
import com.example.facultyservice.repository.FacultyRepository;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class FacultyImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    @RateLimiter(name = "basic", fallbackMethod = "fallMethodRateLimiter")
    public Faculty getFaculty(int id) {
        log.info(LocalDateTime.now() + " :GET FACULTY BY ID");
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

    public Faculty fallMethodRateLimiter(int id, RequestNotPermitted rnp) {
        log.info("Request Not Permitted By Many Request");
        return null;
    }

}
