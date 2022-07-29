package com.revature.models;

public class ReimbursementType {
	private int reimbursement_type_fk;
	private String reimbursement_type;
	
	
	//Boilerplate-------------------------------
	public ReimbursementType() {
			super();
			// TODO Auto-generated constructor stub
		}


	public ReimbursementType(int reimbursement_type_fk, String reimbursement_type) {
		super();
		this.reimbursement_type_fk = reimbursement_type_fk;
		this.reimbursement_type = reimbursement_type;
	}


	@Override
	public String toString() {
		return "ReimbursementType [reimbursement_type_fk=" + reimbursement_type_fk + ", reimbursement_type="
				+ reimbursement_type + "]";
	}


	public int getReimbursement_type_fk() {
		return reimbursement_type_fk;
	}


	public void setReimbursement_type_fk(int reimbursement_type_fk) {
		this.reimbursement_type_fk = reimbursement_type_fk;
	}


	public String getReimbursement_type() {
		return reimbursement_type;
	}


	public void setReimbursement_type(String reimbursement_type) {
		this.reimbursement_type = reimbursement_type;
	}
	
	
	
	
}
