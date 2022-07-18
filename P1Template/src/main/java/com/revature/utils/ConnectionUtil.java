package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {


	public static Connection getConnection() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
			System.out.println("problem occurred locating driver");
		}
		
		
		//Use our database credentials to establish a database connection
		//Hardcoded for now... BAD! we'll change this later to hide them in the Environment Variables
		
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=employee_reimbursement";
		String username = "postgres";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
}
