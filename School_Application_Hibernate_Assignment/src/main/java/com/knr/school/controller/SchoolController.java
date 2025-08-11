package com.knr.school.controller;

import com.knr.school.entities.School;
import com.knr.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    // Add new school
    @PostMapping("/addNewSchool")
    public School addSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    // Get all schools
    @GetMapping("/getAllSchools")
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    // Get school by ID
    @GetMapping("/getSchool/{id}")
    public School getSchoolById(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }

    // Delete school by ID
    @DeleteMapping("/deleteSchool/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String, String>> deleteSchoolById(@PathVariable Long id) {
        schoolService.deleteSchoolById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "School deleted successfully");
        return ResponseEntity.ok(response);
    }

    // Existing mappings
    @PatchMapping("/changeDetailsOfSchool/{id}")
    public School patchSchool(@PathVariable Long id, @RequestBody School patchData) {
        return schoolService.patchSchool(id, patchData);
    }

    @GetMapping("/getSchoolByName")
    public List<School> getSchoolsByName(@RequestParam String name) {
        return schoolService.findSchoolsByNameNative(name);
    }

    @GetMapping("/getSchoolByTeacherQualification")
    public List<School> getSchoolsByTeacherQualification(@RequestParam String qualification) {
        return schoolService.findSchoolsByTeacherQualificationNative(qualification);
    }
}
