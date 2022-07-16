package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
	private int reimbursement_id;
	private int reimbursement_amount;
	private Timestamp reimbursement_submitted;
	private String reimbursement_description;
	private ReimbursementType reimbursement_type;
	private int reimbursement_author_fk;
	private int reimbursement_resolver_fk;
	private ReimbursementResolution reimbursement_resolution;
	
	private int reimbursement_status_fk;
	private int reimbursement_type_fk;
	private int reimbursememnt_resolution_fk;
	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursement(int reimbursement_id, int reimbursement_amount, Timestamp reimbursement_submitted,
			String reimbursement_description, ReimbursementType reimbursement_type, int reimbursement_author_fk, 
			int reimbursement_resolver_fk, ReimbursementResolution reimbursement_resolution) {
		super();
		this.reimbursement_id = reimbursement_id;
		this.reimbursement_amount = reimbursement_amount;
		this.reimbursement_submitted = reimbursement_submitted;
		this.reimbursement_description = reimbursement_description;
		this.reimbursement_type = reimbursement_type;
		this.reimbursement_author_fk = reimbursement_author_fk;
		this.reimbursement_resolver_fk = reimbursement_resolver_fk;
		this.reimbursement_resolution = reimbursement_resolution;
	}


	public Reimbursement(int reimbursement_amount, Timestamp reimbursement_submitted, String reimbursement_description,
			ReimbursementType reimbursement_type, int reimbursement_author_fk,
			int reimbursement_resolver_fk, ReimbursementResolution reimbursement_resolution) {
		super();
		this.reimbursement_amount = reimbursement_amount;
		this.reimbursement_submitted = reimbursement_submitted;
		this.reimbursement_description = reimbursement_description;
		this.reimbursement_type = reimbursement_type;
		this.reimbursement_author_fk = reimbursement_author_fk;
		this.reimbursement_resolver_fk = reimbursement_resolver_fk;
		this.reimbursement_resolution = reimbursement_resolution;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimbursement_id=" + reimbursement_id + ", reimbursement_amount=" + reimbursement_amount
				+ ", reimbursement_submitted=" + reimbursement_submitted + ", reimbursement_description="
				+ reimbursement_description + ", reimbursement_type="
				+ reimbursement_type + ", reimbursement_author_fk=" + reimbursement_author_fk
				+ ", reimbursement_resolver_fk=" + reimbursement_resolver_fk + ", reimbursement_resolution="
				+ reimbursement_resolution + "]";
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


	public Timestamp getReimbursement_submitted() {
		return reimbursement_submitted;
	}


	public void setReimbursement_submitted(Timestamp reimbursement_submitted) {
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


	public ReimbursementResolution getReimbursement_resolution() {
		return reimbursement_resolution;
	}


	public void setReimbursement_resolution(ReimbursementResolution reimbursement_resolution) {
		this.reimbursement_resolution = reimbursement_resolution;
	}


	public int getReimbursement_status_fk() {
		return reimbursement_status_fk;
	}


	public void setReimbursement_status_fk(int reimbursement_status_fk) {
		this.reimbursement_status_fk = reimbursement_status_fk;
	}


	public int getReimbursement_type_fk() {
		return reimbursement_type_fk;
	}


	public void setReimbursement_type_fk(int reimbursement_type_fk) {
		this.reimbursement_type_fk = reimbursement_type_fk;
	}


	public int getReimbursememnt_resolution_fk() {
		return reimbursememnt_resolution_fk;
	}


	public void setReimbursememnt_resolution_fk(int reimbursememnt_resolution_fk) {
		this.reimbursememnt_resolution_fk = reimbursememnt_resolution_fk;
	}
	
	
	
}
