package com.knr.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knr.mapping.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	
}
