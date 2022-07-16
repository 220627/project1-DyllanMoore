package com.revature.DAOS;

import com.revature.models.User;

public interface UserDAOInterface {

	//Add User
	boolean insertUser(User user);
	
	//Delete User
	public void deleteUser(String user);
	
	
	//Update User Information
	boolean updateUserFirstName(String oldName, String newName);
	
	boolean updateUserLastName(String oldName, String newName);
	
	boolean updateUserEmail(String  user, String email);
	
	boolean updateUserRole(String user, int userRole);
	
}
