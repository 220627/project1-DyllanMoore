package com.revature;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import com.revature.DAOS.UserDAO;
import com.revature.models.User;

public class testUserDAO {
	
	UserDAO uDAO = new UserDAO();
	
	@Test
	public void testGetUser() {
		assertNotNull(uDAO.getUser());

	}
	
	@Test 
	public void testInsertUser() {
		User u = new User("John", "Doe", "jdoe", "password", "jdoe@jdoe", 1);
		boolean result = uDAO.insertUser(u);
		assertTrue(result == true);
	}

	@Test 
	public void testUpdateUserFirstName() {
		boolean result = uDAO.updateUserFirstName(1, "John");
		assertTrue(result == true);
	}
	
	@Test 
	public void testUpdateUserLastName() {
		boolean result = uDAO.updateUserLastName(1, "Doe");
		assertTrue(result == true);
	}
	
	@Test 
	public void testUpdateUserEmail() {
		boolean result = uDAO.updateUserEmail(1, "johndoe@gmail.com");
		assertTrue(result == true);
	}
	
	@Test 
	public void testUpdateUserUsername() {
		boolean result = uDAO.updateUserUsername(1, "JohnDoe");
		assertTrue(result == true);
	}
	
	@Test 
	public void testUpdateUserPassword() {
		boolean result = uDAO.updateUserPassword(1, "Password123");
		assertTrue(result == true);
	}
	
}