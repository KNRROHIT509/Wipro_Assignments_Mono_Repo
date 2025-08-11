package com.knr.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knr.mapping.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
}
