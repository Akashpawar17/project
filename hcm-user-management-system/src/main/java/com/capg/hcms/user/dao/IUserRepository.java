package com.capg.hcms.user.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.hcms.user.model.User;
@Repository
public interface IUserRepository extends JpaRepository<User, String>{
public User getUserByUserName(String userName);
	
	public User getUserByContactNumber(BigInteger contactNumber);
	
	public User getUserByUserEmail(String userEmail);
	
    public User getUserByUserNameAndUserPassword(String userName,String userPassword);

}
