package com.srinivasalu.employee.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.http.HttpStatus;



public class ServiceExceptionMapper implements ExceptionMapper<EmployeeServiceException> {

	@Override
	public Response toResponse(EmployeeServiceException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorMessage(ex.getMessage());
		error.setErrorCode(ex.getStatusCode());
		StringWriter writter = new StringWriter();
		ex.printStackTrace(new PrintWriter(writter));
		return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).entity(error).type(MediaType.APPLICATION_JSON)
				.build();
	}

}
