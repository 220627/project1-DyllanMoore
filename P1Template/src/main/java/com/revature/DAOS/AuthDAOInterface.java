package com.revature.DAOS;

import com.revature.models.User;

public interface AuthDAOInterface {
	public User userLogin(String username, String password);
	
	public User adminLogin(String username, String password);
}
