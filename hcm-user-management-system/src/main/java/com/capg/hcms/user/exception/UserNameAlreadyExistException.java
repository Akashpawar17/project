package com.capg.hcms.user.exception;

public class UserNameAlreadyExistException extends Exception {
private static final long serialVersionUID = 1L;
	
	public UserNameAlreadyExistException(String message) {
		super(message);
	}

}
