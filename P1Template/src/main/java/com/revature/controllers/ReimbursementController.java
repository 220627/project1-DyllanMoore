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
		String body = ctx.body();
		Gson gson = new Gson();
		Reimbursement newReimbursement = gson.fromJson(body,  Reimbursement.class);
		
		if(rDAO.newReimbursement(newReimbursement)) {
			ctx.status(202);
		} else {
			ctx.status(406);
		}
	};
	
	//Delete Reimbursement
	public Handler deleteReimbursementHandler = (ctx) -> {
		int reimbursementId = Integer.parseInt(ctx.pathParam("reimbursementId"));
		rDAO.deleteReimbursement(reimbursementId);
		
		ctx.result("Reimbursement Id #" + reimbursementId + " has been removed from the Monsters Inc Database.");
		ctx.status(202);
	};
	
	//Update Reimbursements
	public Handler updateReimbursementResolutionHandler = (ctx) -> {
		int reimbursementUpdateId = Integer.parseInt(ctx.pathParam("updateresolution"));
		int resolution = Integer.parseInt(ctx.body());
		rDAO.updateReimbursementResolution(reimbursementUpdateId, resolution);
		
		ctx.status(202);
		ctx.result("Reimbursement Id # " + reimbursementUpdateId + "'s amount has been changed to Resolution Id # " + resolution);
	};
	
	
	//Get Reimbursements
	public Handler getReimbursementHandler = (ctx) -> {
		ArrayList<Reimbursement> reimbursement = rDAO.getReimbursement();
		Gson gson = new Gson();
		String Jsonreimbursement = gson.toJson(reimbursement);
		ctx.result(Jsonreimbursement);
		ctx.status(200);
	};
}
