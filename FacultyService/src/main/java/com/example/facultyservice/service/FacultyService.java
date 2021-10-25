package com.example.facultyservice.service;

import com.example.facultyservice.entity.Faculty;

import java.util.List;

public interface FacultyService {
    public Faculty getFaculty(int id);
    public List<Faculty> getListFaculty();
    public void addFaculty(Faculty faculty);
    public void updateFaculty(int id, Faculty faculty);
    public void deleteFaculty(int id);
}
