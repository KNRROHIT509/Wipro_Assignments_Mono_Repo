package com.knr.school.service;

import com.knr.school.entities.School;
import com.knr.school.entities.Teacher;
import com.knr.school.repository.SchoolRepository;
import com.knr.school.repository.TeacherRepository;


import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
    private TeacherRepository teacherRepository;
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	
    public Teacher createTeacher(Teacher teacher) {
    	if (teacher.getSchool() != null) {
            School school = teacher.getSchool();
            if (school.getId() != null) {
            	final Long schoolId = school.getId();
                // Fetch using a new variable
                School managedSchool = schoolRepository.findById(schoolId)
                    .orElseThrow(() -> new EntityNotFoundException("School not found with id: " + schoolId));
                teacher.setSchool(managedSchool);
            } else {
                school = schoolRepository.save(school);
                teacher.setSchool(school);
            }
        }
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id: " + id));
    }

    public void deleteTeacherById(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotFoundException("Teacher not found with id: " + id);
        }
        teacherRepository.deleteById(id);
    }

    public Teacher patchTeacher(Long id, Teacher patchData) {
        Teacher existingTeacher = getTeacherById(id);
        // Apply partial updates (only if fields are provided)
        if (patchData.getTeacherName() != null) {
            existingTeacher.setTeacherName(patchData.getTeacherName());
        }
        if (patchData.getQualification() != null) {
            existingTeacher.setQualification(patchData.getQualification());
        }
        return teacherRepository.save(existingTeacher);
    }

    public List<Teacher> teachersWithExperienceGreaterThan(int years) {
        // Assuming a repository method like findByExperienceGreaterThan(years)
        return teacherRepository.findByExperienceGreaterThan(years);
    }

    public List<Teacher> findByQualificationNative(String qualification) {
        // Assuming a native query method in repository
        return teacherRepository.findByQualificationNative(qualification);
    }
}
