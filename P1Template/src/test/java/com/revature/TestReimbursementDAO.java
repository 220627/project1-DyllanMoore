package com.revature;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.DAOS.ReimbursementDAO;
import com.revature.models.Reimbursement;

public class TestReimbursementDAO {
	
	ReimbursementDAO rDAO = new ReimbursementDAO();

	@Test
	public void testGetReimbursement() {
		assertNotNull(rDAO.getReimbursement());
	}
	
	@Test
	public void testInsertReimbursement() {
		Reimbursement r = new Reimbursement(999, "07/27/2022", "Grandy's", 2, 1, 1, 1);
		boolean result = rDAO.newReimbursement(r);
		assertTrue(result == true);
	}
	
	@Test 
	public void testUpdateReimbursementResolution() {
		boolean result = rDAO.updateReimbursementResolution(1, 2);
		assertTrue(result == true);
	}
}
