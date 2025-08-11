package com.knr.school.service;

import com.knr.school.entities.Teacher;
import java.util.List;

public interface TeacherService {
    Teacher patchTeacher(Long id, Teacher teacherPatchData);
    List<Teacher> teachersWithExperienceGreaterThan(int years);
    List<Teacher> findByQualificationNative(String qualification);
	Teacher createTeacher(Teacher teacher);
	List<Teacher> getAllTeachers();
	Teacher getTeacherById(Long id);
	void deleteTeacherById(Long id);
}
