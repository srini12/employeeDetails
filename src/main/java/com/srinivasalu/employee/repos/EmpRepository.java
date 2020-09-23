package com.srinivasalu.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srinivasalu.employee.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long> {

	//Employee save(Collection<? extends Project> setProjects);	
	
}
