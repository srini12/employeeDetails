package com.srinivasalu.employee.exceptions;

public class EmployeeServiceException extends Exception {

	private int statusCode;

	public EmployeeServiceException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
