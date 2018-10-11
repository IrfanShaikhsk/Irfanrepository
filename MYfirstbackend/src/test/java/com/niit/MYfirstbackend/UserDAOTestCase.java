package com.niit.MYfirstbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

public class UserDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	@Test
	public void saveUserTestCase()
	{
		User user = new User();
		user.setUsername("irfan");
		user.setPassword("irfan");
		user.setRole("user");
		user.setCustomerName("Myuser");
		user.setMobileNo("9090909090");
		user.setEmailId("abc@xyz.com");
		user.setAddress("mumbai");
		
		
		assertTrue("Problem in Saving User",userDAO.save(user));
	}
	
	@Ignore
	@Test
	public void deleteUserTestCase()
	{
		boolean actual = userDAO.delete("asd");
		assertEquals("Delete User", true, actual);
	}
	@Ignore
	@Test
	public void getParticularUsers()
	{
		int size = userDAO.list("user").size();
		assertEquals(2, size);
	}

}