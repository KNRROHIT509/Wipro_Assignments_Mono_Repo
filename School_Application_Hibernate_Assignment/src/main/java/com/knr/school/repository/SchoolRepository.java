package com.knr.school.repository;

import com.knr.school.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query(value = "SELECT * FROM School WHERE school_name = ?1", nativeQuery = true)
    List<School> findSchoolsByNameNative(String name);

    @Query(value = "SELECT * FROM School s WHERE s.id IN (SELECT t.school_id FROM Teacher t WHERE t.qualification = ?1)", nativeQuery = true)
    List<School> findSchoolsByTeacherQualificationNative(String qualification);
}
