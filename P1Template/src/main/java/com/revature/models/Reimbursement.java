package com.revature.models;


public class Reimbursement {
	private int reimbursement_id;
	private int reimbursement_amount;
	private String reimbursement_submitted;
	private String reimbursement_description;
	private ReimbursementType reimbursement_type;
	private ReimbursementAuthor reimbursement_author;
	private ReimbursementResolver reimbursement_resolver;
	private ReimbursementResolution reimbursement_resolution;
	
	private int reimbursement_type_fk;
	private int reimbursement_author_fk;
	private int reimbursement_resolver_fk;
	private int reimbursement_resolution_fk;

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimbursement_id, int reimbursement_amount, String reimbursement_submitted,
			String reimbursement_description, ReimbursementType reimbursement_type,
			ReimbursementAuthor reimbursement_author, ReimbursementResolver reimbursement_resolver,
			ReimbursementResolution reimbursement_resolution) {
		super();
		this.reimbursement_id = reimbursement_id;
		this.reimbursement_amount = reimbursement_amount;
		this.reimbursement_submitted = reimbursement_submitted;
		this.reimbursement_description = reimbursement_description;
		this.reimbursement_type = reimbursement_type;
		this.reimbursement_author = reimbursement_author;
		this.reimbursement_resolver = reimbursement_resolver;
		this.reimbursement_resolution = reimbursement_resolution;
	}
	
	public Reimbursement(int reimbursement_amount, String reimbursement_submitted, String reimbursement_description,
			ReimbursementType reimbursement_type, ReimbursementAuthor reimbursement_author,
			ReimbursementResolver reimbursement_resolver, ReimbursementResolution reimbursement_resolution) {
		super();
		this.reimbursement_amount = reimbursement_amount;
		this.reimbursement_submitted = reimbursement_submitted;
		this.reimbursement_description = reimbursement_description;
		this.reimbursement_type = reimbursement_type;
		this.reimbursement_author = reimbursement_author;
		this.reimbursement_resolver = reimbursement_resolver;
		this.reimbursement_resolution = reimbursement_resolution;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursement_id=" + reimbursement_id + ", reimbursement_amount=" + reimbursement_amount
				+ ", reimbursement_submitted=" + reimbursement_submitted + ", reimbursement_description="
				+ reimbursement_description + ", reimbursement_type=" + reimbursement_type + ", reimbursement_author="
				+ reimbursement_author + ", reimbursement_resolver=" + reimbursement_resolver
				+ ", reimbursement_resolution=" + reimbursement_resolution + "]";
	}

	public int getReimbursement_id() {
		return reimbursement_id;
	}

	public void setReimbursement_id(int reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}

	public int getReimbursement_amount() {
		return reimbursement_amount;
	}

	public void setReimbursement_amount(int reimbursement_amount) {
		this.reimbursement_amount = reimbursement_amount;
	}

	public String getReimbursement_submitted() {
		return reimbursement_submitted;
	}

	public void setReimbursement_submitted(String reimbursement_submitted) {
		this.reimbursement_submitted = reimbursement_submitted;
	}

	public String getReimbursement_description() {
		return reimbursement_description;
	}

	public void setReimbursement_description(String reimbursement_description) {
		this.reimbursement_description = reimbursement_description;
	}

	public ReimbursementType getReimbursement_type() {
		return reimbursement_type;
	}

	public void setReimbursement_type(ReimbursementType reimbursement_type) {
		this.reimbursement_type = reimbursement_type;
	}

	public ReimbursementAuthor getReimbursement_author() {
		return reimbursement_author;
	}

	public void setReimbursement_author(ReimbursementAuthor reimbursement_author) {
		this.reimbursement_author = reimbursement_author;
	}

	public ReimbursementResolver getReimbursement_resolver() {
		return reimbursement_resolver;
	}

	public void setReimbursement_resolver(ReimbursementResolver reimbursement_resolver) {
		this.reimbursement_resolver = reimbursement_resolver;
	}

	public ReimbursementResolution getReimbursement_resolution() {
		return reimbursement_resolution;
	}

	public void setReimbursement_resolution(ReimbursementResolution reimbursement_resolution) {
		this.reimbursement_resolution = reimbursement_resolution;
	}

	public int getReimbursement_type_fk() {
		return reimbursement_type_fk;
	}

	public void setReimbursement_type_fk(int reimbursement_type_fk) {
		this.reimbursement_type_fk = reimbursement_type_fk;
	}

	public int getReimbursement_resolution_fk() {
		return reimbursement_resolution_fk;
	}

	public void setReimbursement_resolution_fk(int reimbursememnt_resolution_fk) {
		this.reimbursement_resolution_fk = reimbursememnt_resolution_fk;
	}

	public int getReimbursement_author_fk() {
		return reimbursement_author_fk;
	}

	public void setReimbursement_author_fk(int reimbursement_author_fk) {
		this.reimbursement_author_fk = reimbursement_author_fk;
	}

	public int getReimbursement_resolver_fk() {
		return reimbursement_resolver_fk;
	}

	public void setReimbursement_resolver_fk(int reimbursement_resolver_fk) {
		this.reimbursement_resolver_fk = reimbursement_resolver_fk;
	}
		
	
	
}