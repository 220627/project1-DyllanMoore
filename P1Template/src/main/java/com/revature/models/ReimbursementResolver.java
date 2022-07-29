package com.revature.models;

public class ReimbursementResolver {
	private int reimbursement_resolver_fk;
	private String reimbursement_resolver;
	
	
	public ReimbursementResolver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementResolver(int reimbursement_resolver_fk, String reimbursement_resolver) {
		super();
		this.reimbursement_resolver_fk = reimbursement_resolver_fk;
		this.reimbursement_resolver = reimbursement_resolver;
	}

	@Override
	public String toString() {
		return "ReimbursementResolver [reimbursement_resolver_fk=" + reimbursement_resolver_fk
				+ ", reimbursement_resolver=" + reimbursement_resolver + "]";
	}

	public int getReimbursement_resolver_fk() {
		return reimbursement_resolver_fk;
	}

	public void setReimbursement_resolver_fk(int reimbursement_resolver_fk) {
		this.reimbursement_resolver_fk = reimbursement_resolver_fk;
	}

	public String getReimbursement_resolver() {
		return reimbursement_resolver;
	}

	public void setReimbursement_resolver(String reimbursement_resolver) {
		this.reimbursement_resolver = reimbursement_resolver;
	}

}
