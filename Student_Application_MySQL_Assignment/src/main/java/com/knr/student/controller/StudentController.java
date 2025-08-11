package com.knr.student.controller;

import com.knr.student.entities.Student;
import com.knr.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String saveStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/read";
    }

    @GetMapping("/read")
    public String readStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "read";
    }

    @GetMapping("/update")
    public String updatePage(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "update";
    }

    @GetMapping("/update/form/{rollno}")
    public String updateForm(@PathVariable Long rollno, Model model) {
        model.addAttribute("student", service.getStudentById(rollno));
        return "edit";
    }

    @PostMapping("/update/{rollno}")
    public String updateStudent(@PathVariable Long rollno, @ModelAttribute Student student) {
        service.updateStudent(rollno, student);
        return "redirect:/update";
    }

    @GetMapping("/delete")
    public String deletePage(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "delete";
    }

    @GetMapping("/delete/{rollno}")
    public String deleteStudent(@PathVariable Long rollno) {
        service.deleteStudent(rollno);
        return "redirect:/delete";
    }
}
