package com.knr.school.service;

import com.knr.school.entities.School;
import com.knr.school.repository.SchoolRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
    private SchoolRepository schoolRepository;

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("School not found with id: " + id));
    }

    public void deleteSchoolById(Long id) {
        if (!schoolRepository.existsById(id)) {
            throw new EntityNotFoundException("School not found with id: " + id);
        }
        schoolRepository.deleteById(id);
    }

    public School patchSchool(Long id, School patchData) {
        School existingSchool = getSchoolById(id);
        // Apply partial updates (only if fields are provided)
        if (patchData.getSchoolName() != null) {
            existingSchool.setSchoolName(patchData.getSchoolName());
        }
        // Add similar checks for other fields in your School entity
        return schoolRepository.save(existingSchool);
    }

    public List<School> findSchoolsByNameNative(String name) {
        // Assuming a native query method in repository, e.g., @Query(value = "SELECT * FROM school WHERE name = :name", nativeQuery = true)
        return schoolRepository.findSchoolsByNameNative(name);
    }

    public List<School> findSchoolsByTeacherQualificationNative(String qualification) {
        // Assuming a native query method in repository
        return schoolRepository.findSchoolsByTeacherQualificationNative(qualification);
    }
}
