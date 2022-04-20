package com.srinivasalu.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srinivasalu.employee.exceptions.EmployeeServiceException;
import com.srinivasalu.employee.model.Employee;
import com.srinivasalu.employee.model.Project;
import com.srinivasalu.employee.repos.AddressRepository;
import com.srinivasalu.employee.repos.EmpRepository;
import com.srinivasalu.employee.repos.ProjectRespository;

@RestController
public class EmpController {
	@Autowired
	private EmpRepository erepo;

	@Autowired
	private ProjectRespository prepo;

	@Autowired
	private AddressRepository arepo;

	// add employee with projects and address
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) throws EmployeeServiceException {

		if (employee.getName() == null || employee.getName().isEmpty()) {
			throw new EmployeeServiceException("Name should not be empty or null", HttpStatus.BAD_REQUEST.value());

		} else {
			employee = erepo.save(employee);
			for (Project pr : employee.getProjects()) {
				pr.setEmployee(employee);
			}
			employee.setProjects(prepo.saveAll(employee.getProjects()));
			employee.setAddress(arepo.save(employee.getAddress()));
			return erepo.save(employee);
		}

		//Hello

	}

	// get all employees
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return (List<Employee>) erepo.findAll();
	}
	
	//get single employee with id
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable Long id) throws EmployeeServiceException {
		Employee employee = erepo.findById(id).get();
		if (employee == null) {
			throw new EmployeeServiceException("Employee Not Found : " + id, HttpStatus.CONFLICT.value());
		}
		return employee;
	}
	
	//update employee with id
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
		Employee emp = erepo.findById(id).get();
		emp.setName(employee.getName());
		emp.setDesignation(employee.getDesignation());
		return erepo.save(emp);
	}
	
	//delete employee with id
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable long id) {
		Employee emp = erepo.findById(id).get();
		erepo.delete(emp);
		return "resource deleted";
	}
}
