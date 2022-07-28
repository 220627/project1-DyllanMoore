package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.DAOS.UserDAO;
import com.revature.models.User;

import io.javalin.http.Handler;

public class UserController {

	UserDAO uDAO = new UserDAO();
	
	//Add User
	public Handler insertUserHandler = (ctx) -> {
		
		String body = ctx.body();
		Gson gson = new Gson();
		User newUser = gson.fromJson(body,  User.class);
		
		if(uDAO.insertUser(newUser)) {
			ctx.status(202);
		} else {
			ctx.status(406);
		}
		
	};
	
	//Update User Information
	public Handler updateUserFirstNameHandler = (ctx) -> {
		int userId = Integer.parseInt(ctx.pathParam("userId"));
		String first_name = ctx.body();
		uDAO.updateUserFirstName(userId, first_name);
		
		ctx.status(202);
		ctx.result("User Id # " + userId + "'s name was updated to " + first_name);
		
	};
	
	public Handler updateUserLastNameHandler = (ctx) -> {
		int userId = Integer.parseInt(ctx.pathParam("userId"));
		String last_name = ctx.body();
		uDAO.updateUserLastName(userId, last_name);
		
		ctx.status(202);
		ctx.result("User Id # " + userId + "'s name was updated to " + last_name);
		
	};
	
	public Handler updateUserEmailHandler = (ctx) -> {
		int userId = Integer.parseInt(ctx.pathParam("userId"));
		String email = ctx.body();
		uDAO.updateUserEmail(userId, email);
		
		ctx.status(202);
		ctx.result("User Id # " + userId + "'s email was updated to " + email);
		
	};
	
	public Handler updateUserRoleHandler = (ctx) -> {
		int userId = Integer.parseInt(ctx.pathParam("userId"));
		int roleId = Integer.parseInt(ctx.body());
		uDAO.updateUserRole(userId, roleId);
		
		ctx.status(202);
		ctx.result("User Id # " + userId + "'s role was updated to Role Id # " + roleId);
		
	};
	
	public Handler updateUserPasswordHandler = (ctx) -> {
		int userId = Integer.parseInt(ctx.pathParam("userId"));
		String password = ctx.body();
		uDAO.updateUserPassword(userId, password);
		
		ctx.status(202);
		ctx.result("User Id # " + userId + "'s password has been changed.");
	};
	
	public Handler updateUserUsernameHandler = (ctx) -> {
		int userId = Integer.parseInt(ctx.pathParam("userId"));
		String username = ctx.body();
		uDAO.updateUserUsername(userId, username);
		
		ctx.status(202);
		ctx.result("User Id # " + userId + "'s username has been updated to " + username);
	};
	
	
	
	
	//Get All Users
	public Handler getUserHandler = (ctx) -> {
		ArrayList<User> user = uDAO.getUser();
		Gson gson = new Gson();
		String Jsonuser = gson.toJson(user);
		ctx.result(Jsonuser);
		ctx.status(200);
	};
}
