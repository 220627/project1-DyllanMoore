package com.revature.models;

public class ReimbursementResolution {
	private int reimbursement_resolution_id;
	private String reimbursement_resolution;
	
	//Boilerplate-----------------------------------
	public ReimbursementResolution() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementResolution(int reimbursement_resolution_id, String reimbursement_resolution) {
		super();
		this.reimbursement_resolution_id = reimbursement_resolution_id;
		this.reimbursement_resolution = reimbursement_resolution;
	}

	public ReimbursementResolution(String reimbursement_resolution) {
		super();
		this.reimbursement_resolution = reimbursement_resolution;
	}

	@Override
	public String toString() {
		return "ReimbursementResolution [reimbursement_resolution_id=" + reimbursement_resolution_id
				+ ", reimbursement_resolution=" + reimbursement_resolution + "]";
	}

	public int getReimbursement_resolution_id() {
		return reimbursement_resolution_id;
	}

	public void setReimbursement_resolution_id(int reimbursement_resolution_id) {
		this.reimbursement_resolution_id = reimbursement_resolution_id;
	}

	public String getReimbursement_resolution() {
		return reimbursement_resolution;
	}

	public void setReimbursement_resolution(String reimbursement_resolution) {
		this.reimbursement_resolution = reimbursement_resolution;
	}
	
	
	
}
