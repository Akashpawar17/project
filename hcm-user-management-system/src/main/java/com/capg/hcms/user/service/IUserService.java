package com.capg.hcms.user.service;

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
public interface IUserService {
	
	public User registerUser(User user) throws UserEmailInvalidException, UserNameInvalidException, UserPasswordInvalidException, UserNumberInvalidException, UserNameAlreadyExistException, ContactNumberAlreadyExistException, EmailAlreadyExistException;
	public boolean deleteUser(String userId) throws UserNotFoundException;
	public User updateUser(User user) throws UserNotFoundException;
	public User getUserById(String userId) throws UserNotFoundException;
	public User login(String userId,String password) throws UserNotFoundException;
	public User registerAdmin(User user) throws PassKeyMisMatchException;

}
