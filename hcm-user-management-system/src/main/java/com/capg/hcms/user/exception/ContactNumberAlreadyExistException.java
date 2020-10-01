package com.capg.hcms.user.exception;

public class ContactNumberAlreadyExistException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public ContactNumberAlreadyExistException(String message) {
		super(message);
	}
}
