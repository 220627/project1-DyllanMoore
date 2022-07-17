package com.revature.models;

public class ReimbursementAuthor {
	private int reimbursement_author_fk;

	public ReimbursementAuthor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementAuthor(int reimbursement_author_fk) {
		super();
		this.reimbursement_author_fk = reimbursement_author_fk;
	}

	@Override
	public String toString() {
		return "ReimbursementAuthor [reimbursement_author_fk=" + reimbursement_author_fk + "]";
	}

	public int getReimbursement_author_fk() {
		return reimbursement_author_fk;
	}

	public void setReimbursement_author_fk(int reimbursement_author_fk) {
		this.reimbursement_author_fk = reimbursement_author_fk;
	}
	
	
}
