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
	public void testUpdateUser() {
		boolean result = uDAO.updateUserFirstName(1, "John");
		assertTrue(result == true);
	}
}