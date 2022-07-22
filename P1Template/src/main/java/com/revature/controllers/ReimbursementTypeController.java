//package com.revature.controllers;
//
//import com.revature.DAOS.ReimbursementTypeDAO;
//
//import io.javalin.http.Handler;
//
//public class ReimbursementTypeController {
//
//	ReimbursementTypeDAO rtDAO = new ReimbursementTypeDAO();
//	
//	//Update Reimbursement Type Name
//	public Handler updateReimbursementTypeNameHandler = (ctx) -> {
//		String oldType = ctx.pathParam("type");
//		String newType = ctx.body();
//		rtDAO.updateReimbursementType(newType, oldType);
//		
//		ctx.result(oldType + "'s name has been changed to "+ newType);
//	};
//}
