package com.knr.school.service;

import com.knr.school.entities.School;
import java.util.List;

public interface SchoolService {
    School patchSchool(Long id, School schoolPatchData);
    List<School> findSchoolsByNameNative(String name);
    List<School> findSchoolsByTeacherQualificationNative(String qualification);
	School createSchool(School school);
	List<School> getAllSchools();
	School getSchoolById(Long id);
	void deleteSchoolById(Long id);
}
