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
		if(AdminAuthController.ses != null || UserAuthController.ses != null) {
			int userId = Integer.parseInt(ctx.pathParam("userId"));
			String first_name = ctx.body();
			uDAO.updateUserFirstName(userId, first_name);
			
			ctx.status(202);
			ctx.result("User Id # " + userId + "'s name was updated to " + first_name);
		} else {
			ctx.status(401);
		}
	};
	
	public Handler updateUserLastNameHandler = (ctx) -> {
		if(AdminAuthController.ses != null || UserAuthController.ses != null) {
			int userId = Integer.parseInt(ctx.pathParam("userId"));
			String last_name = ctx.body();
			uDAO.updateUserLastName(userId, last_name);
			
			ctx.status(202);
			ctx.result("User Id # " + userId + "'s name was updated to " + last_name);
		} else {
			ctx.status(401);
		}
	};
	
	public Handler updateUserEmailHandler = (ctx) -> {
		if(AdminAuthController.ses != null || UserAuthController.ses != null) {
			int userId = Integer.parseInt(ctx.pathParam("userId"));
			String email = ctx.body();
			uDAO.updateUserEmail(userId, email);
			
			ctx.status(202);
			ctx.result("User Id # " + userId + "'s email was updated to " + email);
		} else {
			ctx.status(401);
		}
	};
	
	public Handler updateUserRoleHandler = (ctx) -> {
		if(AdminAuthController.ses != null || UserAuthController.ses != null) {
			int userId = Integer.parseInt(ctx.pathParam("userId"));
			int roleId = Integer.parseInt(ctx.body());
			uDAO.updateUserRole(userId, roleId);
			
			ctx.status(202);
			ctx.result("User Id # " + userId + "'s role was updated to Role Id # " + roleId);
		} else {
			ctx.status(401);
		}
	};
	
	public Handler updateUserPasswordHandler = (ctx) -> {
		if(AdminAuthController.ses != null || UserAuthController.ses != null) {
			int userId = Integer.parseInt(ctx.pathParam("userId"));
			String password = ctx.body();
			uDAO.updateUserPassword(userId, password);
			
			ctx.status(202);
			ctx.result("User Id # " + userId + "'s password has been changed.");
		} else {
			ctx.status(401);
		}
	};
	
	public Handler updateUserUsernameHandler = (ctx) -> {
		if(AdminAuthController.ses != null || UserAuthController.ses != null) {
			int userId = Integer.parseInt(ctx.pathParam("userId"));
			String username = ctx.body();
			uDAO.updateUserUsername(userId, username);
			
			ctx.status(202);
			ctx.result("User Id # " + userId + "'s username has been updated to " + username);
		} else {
			ctx.status(401);
		}
	};
	
	
	
	
	//Get All Users
	public Handler getUserHandler = (ctx) -> {
		if(AdminAuthController.ses != null) {
			ArrayList<User> user = uDAO.getUser();
			Gson gson = new Gson();
			String Jsonuser = gson.toJson(user);
			ctx.result(Jsonuser);
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};
}
