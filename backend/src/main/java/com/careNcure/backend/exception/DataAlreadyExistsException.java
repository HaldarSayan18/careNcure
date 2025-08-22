package com.careNcure.backend.exception;

public class DataAlreadyExistsException extends RuntimeException{
	private String message;

	public DataAlreadyExistsException(String message) {
		super();
		this.message = message;
	}
	public DataAlreadyExistsException() {
		super();
		this.message="Already exists";
	}
	@Override
	public String getMessage() {
		return this.message;
	}
}
