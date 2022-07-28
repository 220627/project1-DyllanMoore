package com.revature.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class AuthDAO implements AuthDAOInterface{

	@Override
	public User userLogin(String username, String password) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from users where username = ? and password = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User u = new User(
						rs.getInt("user_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getInt("user_role_fk")
						);
				return u;
			}
		} catch(SQLException e) {
			System.out.println("Login Failed");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User adminLogin(String username, String password) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from users where username = ? and password = ? and user_role_fk = 5;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User u = new User(
						rs.getInt("user_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getInt("user_role_fk")
						);
				return u;
			}
		} catch(SQLException e) {
			System.out.println("Login Failed");
			e.printStackTrace();
		}
		return null;
	}
}
