package com.knr.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knr.mapping.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}