package com.revature.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class ReimbursementTypeDAO implements ReimbursementTypeDAOInterface{

	@Override
	public boolean updateReimbursementType(String newType, String oldType) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update jojamart_roles set job_role = ? where job_role = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newType);
			ps.setString(2, oldType);
			ps.executeUpdate();
			System.out.println(oldType + "'s name was updated to " + newType);
			
			return true;
		} catch(SQLException e) {
			System.out.println("Update Role Name Failed");
			e.printStackTrace();
			
		}
		return false;
	}

}
