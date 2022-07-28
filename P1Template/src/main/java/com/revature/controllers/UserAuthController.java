package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.AuthServices;

import io.javalin.http.Handler;

public class UserAuthController {

	AuthServices as = new AuthServices();
	static HttpSession ses;
	
	public Handler userLoginHandler = (ctx) -> {
		String body = ctx.body();
		Gson gson = new Gson();
		
		LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
		User user = as.userLogin(lDTO.getUsername(), lDTO.getPassword());
		if(user != null) {
			ses = ctx.req.getSession();
			String userJSON = gson.toJson(user);
			ctx.result(userJSON);
			ctx.status(202);
		} else {
			ctx.status(401);
		}
	};
}
