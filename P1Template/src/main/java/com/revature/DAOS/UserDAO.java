package com.revature.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAO implements UserDAOInterface{

	@Override
	public boolean insertUser(User user) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "insert into users(first_name, last_name, username, password, email, user_role_fk) values (?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getFirst_name());
			ps.setString(2, user.getLast_name());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getUser_role_fk());
			
			System.out.println(user.getFirst_name() + " " + user.getLast_name() + " was added to the Monsters Inc Database.");
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Adding User Failed");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void deleteUser(String first_name, String last_name) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "delete from users where first_name = ? and last_name = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			System.out.println(first_name + " " + last_name + " was deleted fromt he Monsters Inc Database");
			
		} catch(SQLException e) {
			System.out.println("Delete User Failed");
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean updateUserFirstName(String newName, String first_name, String last_name) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update users set first_name = ? where first_name = ? and last_name = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, first_name);
			ps.setString(3, last_name);
			ps.executeUpdate();
			System.out.println(first_name + " " + last_name + "'s first name was changed to " + newName);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update User First Name Failed");
			e.fillInStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUserLastName(String newName, String first_name, String last_name) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update users set last_name = ? where first_name = ? and last_name = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, first_name);
			ps.setString(3, last_name);
			ps.executeUpdate();
			System.out.println(first_name + " " + last_name + "'s last name was changed to " + newName);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update User Last Name Failed");
			e.fillInStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUserEmail(int user, String email) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update users set email = ? where user_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setInt(2, user);
			ps.executeUpdate();
			System.out.println("User # " + user + "'s email was changed to " + email);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update User Email Failed");
			e.fillInStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUserRole(int user, int userRole) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update users set userRole = ? where user_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userRole);
			ps.setInt(2, user);
			ps.executeUpdate();
			System.out.println("User # " + user + "'s role was changed to Role Id: " + userRole);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update User Role Failed");
			e.fillInStackTrace();
		}
		return false;
	}

}
