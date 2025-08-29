package com.wipro.knr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.knr.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {

}
