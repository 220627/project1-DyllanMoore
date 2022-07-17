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
	public Handler updateReimbursementAmountHandler = (ctx) -> {
		int reimbursementId = Integer.parseInt(ctx.pathParam("reimbursementId"));
		int amount = Integer.parseInt(ctx.body());
		rDAO.updateReimbursementAmount(reimbursementId, amount);
		
		ctx.status(202);
		ctx.result("Reimbursement Id # " + reimbursementId + "'s amount has been changed to " + amount);
	};
	
	
	public Handler updateReimbursementDescriptionHandler = (ctx) -> {
		int reimbursementId = Integer.parseInt(ctx.pathParam("reimbursementId"));
		String description = ctx.body();
		rDAO.updateReimbursementDescription(reimbursementId, description);
		
		ctx.status(202);
		ctx.result("Reimbursement Id # " + reimbursementId + "'s description has been changed");
	};
	
	public Handler updateReimbursementTypeHandler = (ctx) -> {
		int reimbursementId = Integer.parseInt(ctx.pathParam("reimbursementId"));
		int type = Integer.parseInt(ctx.body());
		rDAO.updateReimbursementType(reimbursementId, type);
		
		ctx.status(202);
		ctx.result("Reimbursement Id # " + reimbursementId + "'s type has been changed to Type Id # " + type);
	};
	
	public Handler updateReimbursementResolutionHandler = (ctx) -> {
		int reimbursementId = Integer.parseInt(ctx.pathParam("reimbursementId"));
		int resolution = Integer.parseInt(ctx.body());
		rDAO.updateReimbursementResolution(reimbursementId, resolution);
		
		ctx.status(202);
		ctx.result("Reimbursement Id # " + reimbursementId + "'s amount has been changed to Resolution Id # " + resolution);
	};
	
	
	//Get Reimbursements
	public Handler getReimbursementHandler = (ctx) -> {
		ArrayList<Reimbursement> reimbursement = rDAO.getReimbursement();
		Gson gson = new Gson();
		String Jsonreimbursement = gson.toJson(reimbursement);
		ctx.result(Jsonreimbursement);
		ctx.status(200);
	};
	
	public Handler getReimbursementByStatusHandler = (ctx) -> {
		int resolution = Integer.parseInt(ctx.pathParam("resolution"));
		ArrayList<Reimbursement> reimbursement = rDAO.getReimbursementByStatus(resolution);
		Gson gson = new Gson();
		String Jsonreimbursement = gson.toJson(reimbursement);
		ctx.result(Jsonreimbursement);
		ctx.status(200);
	};
	
	public Handler getReimbursementByAuthorHandler = (ctx) -> {
		int authorId = Integer.parseInt(ctx.pathParam("authorId"));
		ArrayList<Reimbursement> reimbursement = rDAO.getReimbursementByAuthor(authorId);
		Gson gson = new Gson();
		String Jsonreimbursement = gson.toJson(reimbursement);
		ctx.result(Jsonreimbursement);
		ctx.status(200);
	};
	
	public Handler getReimbursementByResolverHandler = (ctx) -> {
		int resolverId = Integer.parseInt(ctx.pathParam("resolverId"));
		ArrayList<Reimbursement> reimbursement = rDAO.getReimbursementByResolver(resolverId);
		Gson gson = new Gson();
		String Jsonreimbursement = gson.toJson(reimbursement);
		ctx.result(Jsonreimbursement);
		ctx.status(200);
	};
}
