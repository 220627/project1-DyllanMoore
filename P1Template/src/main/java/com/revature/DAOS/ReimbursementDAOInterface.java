package com.revature.DAOS;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbursementDAOInterface {
	//New Reimbursement
	boolean newReimbursement(Reimbursement reimbursement);
	
	//Update Reimbursement
	boolean updateReimbursementAmount(int reimbursementId, int amount);
	
	boolean updateReimbursementDescription(int reimbursementId, String description);
	
	boolean updateReimbursementType(int reimbursementId, int type);
	
	boolean updateReimbursementResolution(int reimbursementId, int resolution);
	
	//Delete Reimbursement
	public void deleteReimbursement(int reimbursementId);
	
	//Get Reimbursements
	ArrayList<Reimbursement> getReimbursement();
		
	ArrayList<Reimbursement> getReimbursementByStatus(int resolution);
	
	ArrayList<Reimbursement> getReimbursementByAuthor(int author);
	
	ArrayList<Reimbursement> getReimbursementByResolver(int resolver);

	
}
