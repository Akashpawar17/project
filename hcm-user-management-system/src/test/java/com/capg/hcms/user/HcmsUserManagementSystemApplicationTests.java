package com.capg.hcms.user;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.hcms.user.exception.ContactNumberAlreadyExistException;
import com.capg.hcms.user.exception.UserNameAlreadyExistException;
import com.capg.hcms.user.model.User;
import com.capg.hcms.user.service.IUserService;

@SpringBootTest
class HcmsUserManagementSystemApplicationTests {

	
	@Autowired
	IUserService userService;

	User user1;
	User user2;
	User user3;
	
	@BeforeEach
	public void init()
	{	
	   user1=new User("","Akashpawar","akashpawar@12",new BigInteger("9010330067"),"akash11.abd@gmail.com","user",21,"male","");   
	   user2=new User("","Nagendravara","Dhanush@1",new BigInteger("9848969667"),"nagendra.11@gmail.com","user",21,"male","");
	   	}

	@Test
	void testUserNameException()
	{
	    Assertions.assertThrows(UserNameAlreadyExistException.class, ()->
	    {
	    	userService.registerUser(user1);
	    });   		  
	}
	
	@Test
	void testContactNumberException()
	{
	    Assertions.assertThrows(ContactNumberAlreadyExistException.class, ()->
	    {
	    	userService.registerUser(user2);
	    });		  
	}
	
	
	@Test
	void contextLoads() {
	}

}
