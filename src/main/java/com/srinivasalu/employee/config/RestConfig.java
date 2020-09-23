package com.srinivasalu.employee.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.srinivasalu.employee.controllers.EmpController;
import com.srinivasalu.employee.exceptions.ServiceExceptionMapper;



@Component
public class RestConfig extends ResourceConfig{

	public RestConfig(Class<?>... classes) {
		register(EmpController.class);
		register(ServiceExceptionMapper.class);
	}
	
	

}
