package com.capg.hcms.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.user.exception.ContactNumberAlreadyExistException;
import com.capg.hcms.user.exception.EmailAlreadyExistException;
import com.capg.hcms.user.exception.PassKeyMisMatchException;
import com.capg.hcms.user.exception.UserEmailInvalidException;
import com.capg.hcms.user.exception.UserNameAlreadyExistException;
import com.capg.hcms.user.exception.UserNameInvalidException;
import com.capg.hcms.user.exception.UserNotFoundException;
import com.capg.hcms.user.exception.UserNumberInvalidException;
import com.capg.hcms.user.exception.UserPasswordInvalidException;
import com.capg.hcms.user.model.User;
import com.capg.hcms.user.service.UserServiceImp;
/**
 * The UserController class implements for accessing User
 * Management System services
 *
 * @author :P.AkashPawar
 * @since :2020-09-26
 */
@RestController
@RequestMapping("/register")
public class UserController {
	@Autowired
	UserServiceImp service;

	@PostMapping("/adduser")
	public User registerUser(@RequestBody User user) throws UserEmailInvalidException, UserNameInvalidException, UserPasswordInvalidException, UserNumberInvalidException, UserNameAlreadyExistException, ContactNumberAlreadyExistException, EmailAlreadyExistException {

		return service.registerUser(user);

	}

	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) throws UserNotFoundException {
		return service.updateUser(user);

	}

	@GetMapping("/getuser/{userId}")
	public User getUser(@PathVariable("userId") String userId) throws UserNotFoundException {
		return service.getUserById(userId);

	}
	@DeleteMapping("deleteuser/{userId}")
	public boolean deleteUser(@PathVariable("userId") String userId) throws UserNotFoundException {
	return	service.deleteUser(userId);
	
	}
	@PostMapping("/addadmin")
	public User registerAdmin(@RequestBody User user) throws PassKeyMisMatchException
	{
	return service.registerAdmin(user);	
	}
	@GetMapping("login/{userId}/{password}")
public User login(@PathVariable("userId") String userId,@PathVariable("password") String password) throws UserNotFoundException {
	return service.login(userId, password);
		
	}
}
