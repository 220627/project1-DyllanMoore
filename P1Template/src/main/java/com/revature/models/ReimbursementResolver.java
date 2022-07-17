package com.revature.models;

public class ReimbursementResolver {
	private int reimbursement_resolver_fk;

	public ReimbursementResolver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementResolver(int reimbursement_resolver_fk) {
		super();
		this.reimbursement_resolver_fk = reimbursement_resolver_fk;
	}

	@Override
	public String toString() {
		return "ReimbursementResolver [reimbursement_resolver_fk=" + reimbursement_resolver_fk + "]";
	}

	public int getReimbursement_resolver_fk() {
		return reimbursement_resolver_fk;
	}

	public void setReimbursement_resolver_fk(int reimbursement_resolver_fk) {
		this.reimbursement_resolver_fk = reimbursement_resolver_fk;
	}
	
	

}
