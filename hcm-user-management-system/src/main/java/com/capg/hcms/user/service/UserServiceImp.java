package com.capg.hcms.user.service;

import java.util.Random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcms.user.dao.IUserRepository;
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
/**
 * The UserService class implements for accessing User Management
 * System Repository
 *
 * @author :P.AkashPawar
 * @since :2020-09-27
 */
@Service
public class UserServiceImp implements IUserService {
	@Autowired
	IUserRepository repository;
	
	
	@Autowired
	Random random;

	@Override
	public User registerUser(User user) throws UserEmailInvalidException, UserNameInvalidException, UserPasswordInvalidException, UserNumberInvalidException, UserNameAlreadyExistException, ContactNumberAlreadyExistException, EmailAlreadyExistException {
		Pattern p1=Pattern.compile("[A-Z]{1}[a-zA-Z0-9]{6,14}$");
		Matcher m1=p1.matcher(user.getUserName());
		Pattern p2=Pattern.compile("^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$");
		Matcher m2=p2.matcher(user.getUserPassword());
		Pattern p3=Pattern.compile("^(.+)@(.+)$");
		Matcher m3=p3.matcher(user.getUserEmail());
		Pattern p4=Pattern.compile("\\d{10}");
		Matcher m4=p4.matcher(user.getContactNumber().toString());
		if(!(m1.find() &&  m1.group().equals(user.getUserName())))
		{
			throw new UserNameInvalidException("Username should start with capital letter ad size should be 6-14  characters");
			
		}
		else if(!( m2.find() &&  m2.group().equals(user.getUserPassword())) )
		{
   			throw new UserPasswordInvalidException("User password must contain "
   					+ "capital letter,small letters and special character "
   					+ "without starting with number and range should be between 8 and 20");
		}
		else if(!( m3.find() &&  m3.group().equals(user.getUserEmail())) )
		{
   			throw new UserEmailInvalidException("user email is not valid");
		}
		else if(!( m4.find() &&  m4.group().equals(user.getContactNumber().toString())) )
		{
			throw new UserNumberInvalidException("contact number should contain 10 digits and starting may be 7,8 or 9");
		}
		else if(repository.getUserByUserName(user.getUserName())!=null)
			throw new UserNameAlreadyExistException("User with Name "+user.getUserName()+" already exist");
		
		else if(repository.getUserByContactNumber(user.getContactNumber())!=null)
			throw new ContactNumberAlreadyExistException("User with ContactNumber "+user.getContactNumber()+" already exist");
		
		else if(repository.getUserByUserEmail(user.getUserEmail())!=null)
			throw new EmailAlreadyExistException("User with Email "+user.getUserEmail()+" already exist");
		
		else
		 user.setUserId(String.valueOf(random.nextInt(100000)).substring(0, 5));
		 user.setUserRole("customer");
		 repository.save(user);
		 
		
		return user;
	}

	@Override
	public boolean deleteUser(String userId) throws UserNotFoundException {
		
		User user=repository.getOne(userId);
		if(user==null) {
		throw new UserNotFoundException("user doesn't exists");
		}
			repository.deleteById(userId);
			return true;
		
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException {
	User newUser=	repository.getOne(user.getUserId());
	if(newUser==null) {
		throw new UserNotFoundException("user doesn't exists");
	}
	newUser.setUserName(user.getUserName());
	newUser.setUserPassword(user.getUserPassword());
	newUser.setContactNumber(user.getContactNumber());
	newUser.setUserEmail(user.getUserEmail());
		return repository.save(newUser);
	}

	@Override
	public User getUserById(String userId) throws UserNotFoundException {
		if(!repository.existsById(userId)) {
			throw new UserNotFoundException("user not found");
		}
		User user=repository.getOne(userId);
		return user;
	}

	@Override
	public User login(String userId, String password) throws UserNotFoundException {
		
	if(repository.existsById(userId)){
		User user=repository.getOne(userId);
		return user;
	
		
	}
	else {
	
		throw new UserNotFoundException("User not found with userId"+userId);
	}}

	@Override
	public User registerAdmin(User user) throws PassKeyMisMatchException {
		
		user.setUserRole("admin");
		user.setUserId(String.valueOf(random.nextInt(1000)));
		System.out.println(user);
		if(user.getPassKey().equals("11223344"))
		{
			repository.save(user);
		}
		else
		{
			throw new PassKeyMisMatchException("INVALID PASSKEY");
		}
		return user;
	}

}
