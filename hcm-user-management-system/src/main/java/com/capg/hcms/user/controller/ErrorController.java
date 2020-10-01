package com.capg.hcms.user.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.hcms.user.exception.ContactNumberAlreadyExistException;
import com.capg.hcms.user.exception.EmailAlreadyExistException;
import com.capg.hcms.user.exception.PassKeyMisMatchException;
import com.capg.hcms.user.exception.UserEmailInvalidException;
import com.capg.hcms.user.exception.UserNameAlreadyExistException;
import com.capg.hcms.user.exception.UserNameInvalidException;
import com.capg.hcms.user.exception.UserNotFoundException;
import com.capg.hcms.user.exception.UserNumberInvalidException;
import com.capg.hcms.user.exception.UserPasswordInvalidException;
import com.capg.hcms.user.model.ErrorResponse;

/**
 * ErrorController Class for handling Register Management System Exceptions
 *
 * @author :P.AkashPawar
 * @since :2020-09-28
 */
@RestControllerAdvice
public class ErrorController {
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { ContactNumberAlreadyExistException.class })
	public ErrorResponse ContactNumberAlreadyExistsException(Exception ex, HttpServletRequest req) {

		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.value(), req.getRequestURL().toString());

	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { EmailAlreadyExistException.class })
	public ErrorResponse EmailAlreadyExistException(Exception ex, HttpServletRequest req) {

		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.value(), req.getRequestURL().toString());

	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { UserEmailInvalidException.class })
	public ErrorResponse UserEmailInvalidException(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.ordinal(), req.getRequestURI().toString());
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { UserNameAlreadyExistException.class })
	public ErrorResponse UserNameAlreadyExistException(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.ordinal(), req.getRequestURI().toString());
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { UserNotFoundException.class })
	public ErrorResponse UserNotFoundException(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.ordinal(), req.getRequestURI().toString());
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { UserNameInvalidException.class })
	public ErrorResponse UserNameInvalidException(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.ordinal(), req.getRequestURI().toString());
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { PassKeyMisMatchException.class })
	public ErrorResponse PassKeyMisMatchException(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.ordinal(), req.getRequestURI().toString());
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { UserPasswordInvalidException.class })
	public ErrorResponse UserPasswordInvalidException(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.ordinal(), req.getRequestURI().toString());
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { UserNumberInvalidException.class })
	public ErrorResponse UserNumberInvalidException(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.ordinal(), req.getRequestURI().toString());
	}

}
