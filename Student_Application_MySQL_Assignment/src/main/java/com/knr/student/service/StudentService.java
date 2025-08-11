package com.knr.student.service;

import com.knr.student.entities.Student;
import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long rollno);
    Student updateStudent(Long rollno, Student student);
    void deleteStudent(Long rollno);
}
