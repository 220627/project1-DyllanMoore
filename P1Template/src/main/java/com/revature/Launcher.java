package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AdminAuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserAuthController;
import com.revature.controllers.UserController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("Connection successful");
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
				
				).start(3000);
		
		ReimbursementController rc = new ReimbursementController();
		UserController uc = new UserController();
		UserAuthController uac = new UserAuthController();
		AdminAuthController aac = new AdminAuthController();
		
		
		//Reimbursement Actions
		app.post("/newreimbursement", rc.newReimbursementHandler);
		app.put("/updateresolution/:updateresolution", rc.updateReimbursementResolutionHandler);
		app.get("/reimbursement", rc.getReimbursementHandler);
		
		//User Actions
		app.post("/newuser", uc.insertUserHandler);
		app.put("/firstname/:userId", uc.updateUserFirstNameHandler);
		app.put("/lastname/:userId", uc.updateUserLastNameHandler);
		app.put("/useremail/:userId", uc.updateUserEmailHandler);
		app.put("/password/:userId", uc.updateUserPasswordHandler);
		app.put("/uasername/:userId", uc.updateUserUsernameHandler);
		app.put("/role/:userId", uc.updateUserRoleHandler);
		app.get("/user", uc.getUserHandler);
		
		//Login Actions
		app.post("/userlogin", uac.userLoginHandler);
		app.post("/adminlogin", aac.adminLoginHandler);
		
	}
	
}
