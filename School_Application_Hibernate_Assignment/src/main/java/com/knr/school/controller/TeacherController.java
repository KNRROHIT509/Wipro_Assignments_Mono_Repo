package com.knr.school.controller;

import com.knr.school.entities.Teacher;
import com.knr.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    
    @PostMapping("/addNewTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @GetMapping("/getAllTeachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/getTeacher/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/deleteTeacher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String, String>> deleteTeacherById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Teacher deleted successfully");
        return ResponseEntity.ok(response);
    }

    
    @PatchMapping("/changeTeacherDetails/{id}")
    public Teacher patchTeacher(@PathVariable Long id, @RequestBody Teacher patchData) {
        return teacherService.patchTeacher(id, patchData);
    }

    @GetMapping("/getTeacherByExperience")
    public List<Teacher> getTeachersWithExperience(@RequestParam int years) {
        return teacherService.teachersWithExperienceGreaterThan(years);
    }

    @GetMapping("/getTeacherByQualification")
    public List<Teacher> getByQualification(@RequestParam String qualification) {
        return teacherService.findByQualificationNative(qualification);
    }
}
