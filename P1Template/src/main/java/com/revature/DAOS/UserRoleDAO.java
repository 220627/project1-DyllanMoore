package com.revature.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.UserRole;
import com.revature.utils.ConnectionUtil;

public class UserRoleDAO implements UserRoleDAOInterface{

	@Override
	public UserRole getRoleById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){

			String sql = "select * from user_roles where user_role_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) {
				UserRole role = new UserRole(
						rs.getInt("user_role_id"), 
						rs.getString("user_role")
					); 
				
				return role; 	
			}
			
		} catch (SQLException e) {
			System.out.println("Get Role failed"); 
			e.printStackTrace(); 
		}
		return null;
	}

}
