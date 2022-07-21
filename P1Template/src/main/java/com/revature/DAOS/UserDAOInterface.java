package com.revature.DAOS;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAOInterface {

	//Add User
	boolean insertUser(User user);
	
	//Delete User
	public void deleteUser(int userId);
	
	
	//Update User Information
	boolean updateUserFirstName(int userId, String first_name);
	
	boolean updateUserLastName(int userId, String last_name);
		
	boolean updateUserEmail(int user, String email);
	
	boolean updateUserRole(int user, int userRole);
	
	boolean updateUserPassword(int user, String password);
	
	boolean updateUserUsername(int user, String username);
	
	//Get All Users
	ArrayList<User> getUser();
	
}
