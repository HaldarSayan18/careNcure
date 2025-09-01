package com.careNcure.backend.exception;

public class NoDataFoundException extends RuntimeException{
	private String message;

	public NoDataFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
