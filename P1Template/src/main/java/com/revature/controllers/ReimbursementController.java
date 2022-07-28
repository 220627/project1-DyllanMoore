package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.DAOS.ReimbursementDAO;
import com.revature.models.Reimbursement;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	ReimbursementDAO rDAO = new ReimbursementDAO();
	
	//Add Reimbursement
	public Handler newReimbursementHandler = (ctx) -> {
		if(AdminAuthController.ses != null || UserAuthController.ses != null) {
			String body = ctx.body();
			Gson gson = new Gson();
			Reimbursement newReimbursement = gson.fromJson(body,  Reimbursement.class);
			
			if(rDAO.newReimbursement(newReimbursement)) {
				ctx.status(202);
			} else {
				ctx.status(406);
			}
		} else {
			ctx.status(401);
		}
	};

	
	//Update Reimbursements
	public Handler updateReimbursementResolutionHandler = (ctx) -> {
		if(AdminAuthController.ses != null) {
			int reimbursementUpdateId = Integer.parseInt(ctx.pathParam("updateresolution"));
			int resolution = Integer.parseInt(ctx.body());
			rDAO.updateReimbursementResolution(reimbursementUpdateId, resolution);
			
			ctx.status(202);
			ctx.result("Reimbursement Id # " + reimbursementUpdateId + "'s amount has been changed to Resolution Id # " + resolution);
		} else {
			ctx.status(401);
		}
	};
	
	
	//Get Reimbursements
	public Handler getReimbursementHandler = (ctx) -> {
		if(AdminAuthController.ses != null || UserAuthController.ses != null) {
			ArrayList<Reimbursement> reimbursement = rDAO.getReimbursement();
			Gson gson = new Gson();
			String Jsonreimbursement = gson.toJson(reimbursement);
			ctx.result(Jsonreimbursement);
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};
}
