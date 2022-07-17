package com.revature.DAOS;

import com.revature.models.User;

public interface UserDAOInterface {

	//Add User
	boolean insertUser(User user);
	
	//Delete User
	public void deleteUser(String first_name, String last_name);
	
	
	//Update User Information
	boolean updateUserName(int userId, String first_name, String last_name);
		
	boolean updateUserEmail(int user, String email);
	
	boolean updateUserRole(int user, int userRole);
	
}
