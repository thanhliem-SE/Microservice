package com.example.facultyservice.controller;

import com.example.facultyservice.entity.Faculty;
import com.example.facultyservice.service.FacultyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
@Slf4j
public class FacultyRestController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/")
    public List<Faculty> getListFaculty(){
        return facultyService.getListFaculty();
    }

    @GetMapping("/{id}")
    @Cacheable("basic")
    public Faculty getFaculty(@PathVariable("id") int id){
        log.info("=====GET FACULTY BY ID=====");
        return facultyService.getFaculty(id);
    }

    @GetMapping("/deleteCatche")
    @CacheEvict(value="basic", allEntries=true)
    public String deleteCatche(){
        log.info("=====DELETE CATCHE=====");
        return "Delete Catche";
    };

    @PostMapping("/")
    public String addFaculty(@RequestBody Faculty faculty){
        try{
            facultyService.addFaculty(faculty);
            return "Success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String updateFaculty(@PathVariable("id") int id, @RequestBody Faculty faculty){
        try{
            facultyService.updateFaculty(id, faculty);
            return "Success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteFaculty(@PathVariable("id") int id){
        try{
            facultyService.deleteFaculty(id);
            return "Success";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
