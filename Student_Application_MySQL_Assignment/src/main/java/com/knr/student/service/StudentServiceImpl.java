package com.knr.student.service;

import com.knr.student.entities.Student;
import com.knr.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Long rollno) {
        Optional<Student> optional = repository.findById(rollno);
        return optional.orElse(null);
    }

    @Override
    public Student updateStudent(Long rollno, Student updatedStudent) {
        Student student = getStudentById(rollno);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setEmail(updatedStudent.getEmail());
            student.setDob(updatedStudent.getDob());
            student.setAddress(updatedStudent.getAddress());
            return repository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long rollno) {
        repository.deleteById(rollno);
    }
}
