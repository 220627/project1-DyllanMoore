package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.ReimbursementController;
import com.revature.controllers.ReimbursementTypeController;
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
		ReimbursementTypeController rtc = new ReimbursementTypeController();
		UserController uc = new UserController();
		
		
		//Update Reimbursement Type
		app.put("/reimbursement/:type", rtc.updateReimbursementTypeHandler);
		
		//Reimbursement Actions
		app.post("/newreimbursement", rc.newReimbursementHandler);
		app.delete("/deletereimbursement/:reimbursementId", rc.deleteReimbursementHandler);
		app.put("/updateamount/:reimbursementId", rc.updateReimbursementAmountHandler);
		app.put("/updatedescription/:reimbursementId", rc.updateReimbursementDescriptionHandler);
		app.put("/updatetype/:reimbursementId", rc.updateReimbursementTypeHandler);
		app.put("/updateresolution/:reimbursementId", rc.updateReimbursementResolutionHandler);
		app.get("/reimbursement", rc.getReimbursementHandler);
		app.get("/reimbursementstatus/:resolution", rc.getReimbursementByStatusHandler);
		app.get("/reimbursementauthor/:authorId", rc.getReimbursementByAuthorHandler);
		app.get("reimbursementresolver/:resolverId", rc.getReimbursementByResolverHandler);

		
		//User Actions
		app.post("/newuser", uc.insertUserHandler);
		app.delete("/:user", uc.deleteUserHandler);
		app.put("/name/:userId", uc.updateUserNameHandler);
		app.put("useremail/:userId", uc.updateUserEmailHandler);
		app.put("/role/:userId", uc.updateUserRoleHandler);
		app.get("/user", uc.getUserHandler);
		
	}
	
}
