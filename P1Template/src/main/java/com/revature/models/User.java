package com.revature.models;

public class User {
	private int user_id;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private String email;
	private UserRole user_role;
	private int user_role_fk;
	
	//Boilerplate------------------------------
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int user_id, String first_name, String last_name, String username, String password, String email,
			UserRole user_role) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.user_role = user_role;
	}

	public User(String first_name, String last_name, String username, String password, String email,
			UserRole user_role) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.user_role = user_role;
	}

	
	public User(String first_name, String last_name, String username, String password, String email, int user_role_fk) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.user_role_fk = user_role_fk;
	}

	public User(int user_id, String first_name, String last_name, String username, String password, String email,
			int user_role_fk) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.user_role_fk = user_role_fk;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
				+ username + ", password=" + password + ", email=" + email + ", user_role=" + user_role
				+ ", user_role_fk=" + user_role_fk + "]";
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getUser_role() {
		return user_role;
	}

	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}

	public int getUser_role_fk() {
		return user_role_fk;
	}

	public void setUser_role_fk(int user_role_fk) {
		this.user_role_fk = user_role_fk;
	}
	
}
