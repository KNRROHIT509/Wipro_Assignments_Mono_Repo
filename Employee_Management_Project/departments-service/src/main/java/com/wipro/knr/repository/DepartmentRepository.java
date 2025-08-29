package com.wipro.knr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryConfigurationAware;
import org.springframework.stereotype.Repository;

import com.wipro.knr.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepositoryConfigurationAware, JpaRepository<Department,Integer> {

}
