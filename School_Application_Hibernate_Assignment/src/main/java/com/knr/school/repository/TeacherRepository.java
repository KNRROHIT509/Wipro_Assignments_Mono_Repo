package com.knr.school.repository;

import com.knr.school.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByExperienceGreaterThan(int experience);

    @Query(value = "SELECT * FROM Teacher WHERE qualification = ?1", nativeQuery = true)
    List<Teacher> findByQualificationNative(String qualification);
}
