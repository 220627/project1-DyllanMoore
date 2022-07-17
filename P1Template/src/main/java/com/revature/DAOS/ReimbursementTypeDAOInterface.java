package com.revature.DAOS;

import com.revature.models.ReimbursementType;

public interface ReimbursementTypeDAOInterface {
	
	ReimbursementType getTypeById(int id) ;
	
	boolean updateReimbursementType(String newType, String oldType);
	
}
