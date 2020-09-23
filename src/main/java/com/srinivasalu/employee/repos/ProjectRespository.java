package com.srinivasalu.employee.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srinivasalu.employee.model.Project;

@Repository
public interface ProjectRespository extends JpaRepository<Project, Long> {

	

	//List<Project> save(List<Project> projects);	
}
