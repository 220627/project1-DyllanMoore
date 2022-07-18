package com.revature.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementAuthor;
import com.revature.models.ReimbursementResolution;
import com.revature.models.ReimbursementResolver;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.models.UserRole;
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
			
			ps.executeUpdate();
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
	public boolean updateUserName(int userId, String first_name, String last_name) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql1 = "update users set first_name = ? where user_id = ?;";
			String sql2 = "update users set last_name = ? where user_id = ?;";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps1.setString(1, first_name);
			ps1.setInt(2, userId);
			ps1.executeUpdate();
			ps2.setString(1, last_name);
			ps2.setInt(2, userId);
			System.out.println("User Id # " + userId + "'s name was changed to " + first_name + " " + last_name);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update User First Name Failed");
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

	@Override
	public ArrayList<User> getUser() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from users;";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				User u = new User(
						rs.getInt("user_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("email"),
						null
						);
				
				int user_role_fk = rs.getInt("user_role_fk");
				UserRoleDAO urDAO = new UserRoleDAO();
				UserRole ur = urDAO.getRoleById(user_role_fk);
				u.setUser_role(ur);
				u.setUser_role_fk(user_role_fk);
				userList.add(u);
				
			}
			
			return userList;
			
		} catch(SQLException e) {
			System.out.println("Get All Reimbursements Failed");
			e.getStackTrace();
		}
		return null;
	}

}
