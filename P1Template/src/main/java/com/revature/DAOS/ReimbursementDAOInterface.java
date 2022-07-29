package com.revature.DAOS;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbursementDAOInterface {
	//New Reimbursement
	boolean newReimbursement(Reimbursement reimbursement);
	
	//Update Reimbursement
	boolean updateReimbursementResolution(int reimbursementId, int resolution);
		
	//Delete Reimbursement
	public void deleteReimbursement(int reimbursementId);
	
	//Get Reimbursements
	ArrayList<Reimbursement> getReimbursement();
	
}
