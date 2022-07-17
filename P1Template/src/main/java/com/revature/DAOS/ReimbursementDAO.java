package com.revature.DAOS;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementType;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAO implements ReimbursementDAOInterface{

	@Override
	public boolean newReimbursement(Reimbursement reimbursement) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "insert into reimbursements"
					+ "(reimbursement_amount, reimbursement_submitted, reimbursement_description, reimbursement_type_fk, "
					+ "reimbursement_author_fk, reimbursement_resolver_fk, reimbursement_resolution_fk) "
					+ "values (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimbursement.getReimbursement_amount());
			ps.setTimestamp(2, reimbursement.getReimbursement_submitted());
			ps.setString(3, reimbursement.getReimbursement_description());
			ps.setInt(4, reimbursement.getReimbursement_type_fk());
			ps.setInt(5, reimbursement.getReimbursement_author_fk());
			ps.setInt(6, reimbursement.getReimbursement_resolver_fk());
			ps.setInt(7, reimbursement.getReimbursememnt_resolution_fk());
			
			System.out.println("A reimbursement for $" + reimbursement.getReimbursement_amount() + " was added to the Monsters Inc Database by user #  " + reimbursement.getReimbursement_author_fk());
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Adding Reimbursement Failed");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateReimbursementAmount(int reimbursementId, int amount) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update reimbursements set reimbursement_amount = ? where reimbursement_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, amount);
			ps.setInt(2, reimbursementId);
			ps.executeUpdate();
			System.out.println("Reimbursement # " + reimbursementId + "'s amount was changed to $" + amount);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update Reimbursement Amount Failed");
			e.fillInStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateReimbursementDescription(int reimbursementId, String description) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update reimbursements set reimbursement_description = ? where reimbursement_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, description);
			ps.setInt(2, reimbursementId);
			ps.executeUpdate();
			System.out.println("Reimbursement # " + reimbursementId + "'s description was changed to " + description);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update Reimbursement Description Failed");
			e.fillInStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateReimbursementType(int reimbursementId, int type) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update reimbursements set reimbursement_type_fk = ? where reimbursement_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, type);
			ps.setInt(2, reimbursementId);
			ps.executeUpdate();
			System.out.println("Reimbursement # " + reimbursementId + "'s type was changed to type # " + type);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update Reimbursement Type Failed");
			e.fillInStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateReimbursementResolution(int reimbursementId, int resolution) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update reimbursements set reimbursement_resolution_fk = ? where reimbursement_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resolution);
			ps.setInt(2, reimbursementId);
			ps.executeUpdate();
			System.out.println("Reimbursement # " + reimbursementId + "'s resolution was changed to resolution id #" + resolution);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update Reimbursement Resolution Failed");
			e.fillInStackTrace();
		}
		return false;
	}

	@Override
	public void deleteReimbursement(int reimbursementId) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "delete from reimbursements where reimbursement_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursementId);
			ps.executeUpdate();
			System.out.println("Reimbursement Id #" + reimbursementId + " was removed from the Monsters Inc Database.");
			
		} catch(SQLException e) {
			System.out.println("Delete Reimbursement Failed");
			e.getStackTrace();
		}
		
	}

	@Override
	public ArrayList<Reimbursement> getReimbursement() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from reimbursements;";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement(
						rs.getInt("reimbursement_id"),
						rs.getInt("reimbursement_amount"),
						rs.getTimestamp("reimbursment_submitted"),
						rs.getString("reimbursment_description"),
						null, null, null, null
						);
				
				int reimbursement_type_fk = rs.getInt("reimbursement_type_fk");
				ReimbursementTypeDAO rtDAO = new ReimbursementTypeDAO();
				ReimbursementType rt = rtDAO.getTypeById(reimbursement_type_fk);
				r.setReimbursement_type(rt);
				r.setReimbursememnt_resolution_fk(reimbursement_type_fk);
				reimbursementList.add(r);

				
				
			}
			
			return reimbursementList;
			
			
		} catch(SQLException e) {
			System.out.println("Get All Reimbursements Failed");
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementByStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementByAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementByResolver() {
		// TODO Auto-generated method stub
		return null;
	}

}
