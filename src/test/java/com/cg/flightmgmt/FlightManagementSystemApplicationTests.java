package com.cg.flightmgmt;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.flightmgmt.dao.UserDao;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.UserRepository;

@SpringBootTest
class FlightManagementSystemApplicationTests {
@Autowired
private UserRepository userRepo;
@Autowired
UserDao dao;


public void testSave() {
User user=new User();
BigInteger bigInteger=new BigInteger("122");
user.setUserId(bigInteger);
user.setEmail("naveen1133@gmail.com");
user.setMobileNumber("1234565322");
user.setPassword("ABCd");
user.setUserName("Tanma");
user.setUserType("mobile");
 userRepo.save(user);
assertNotNull(userRepo.findById(bigInteger).get());
 
}
public void testForUpdate()
{
	BigInteger bigInteger=new BigInteger("122");
	User t=userRepo.findById(bigInteger).get();
	t.setUserName("abcdefghyii");
	userRepo.save(t);
	assertNotEquals("xyz", userRepo.findById(bigInteger).get().getUserName());	
}


public void testForDelete()
{
	BigInteger bigInteger=new BigInteger("122");
	User u=userRepo.findById(bigInteger).get();
	userRepo.deleteById(bigInteger);
	
}
@Test
public void testForView(){
	{
		List<User> testForView=new ArrayList<>();
		testForView=userRepo.findAll();
		assertNotNull(testForView);
	}
	
}
@Test
public void testForValid() throws UserNotFoundException
{
	BigInteger bigInteger=new BigInteger("1");
	

	User user=new User(bigInteger,  "Tanma",  "Omkar",  "Omtam",  "ABC",
			 "1234567890");
	userRepo.save(user);
	
	 assertNotNull(dao.validateUser(user));
	 
}
}