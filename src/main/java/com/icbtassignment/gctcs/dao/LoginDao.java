package com.icbtassignment.gctcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.icbtassignment.gctcs.entities.CustomerMaster;

public class LoginDao {
	public static CustomerMaster get(DataSource dataSource, String UserName) {
		CustomerMaster Ulist = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select CustomerID,FirstName, LastName, City, MobileNo, Password from customermaster where UserName = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, UserName);
			rset = stmt.executeQuery();

			while (rset.next()) {
				
				String CustomerID = rset.getString("CustomerID");
				String FirstName = rset.getString("FirstName");
				String LastName = rset.getString("LastName");
				String City = rset.getString("City");
				String MobileNo = rset.getString("MobileNo");
				String Password = rset.getString("Password");
				Ulist = new CustomerMaster(CustomerID, FirstName,LastName, City, MobileNo, Password);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return Ulist;
	}
	
	public static Boolean checkAuthentication(DataSource dataSource, String UserName) {
		boolean result = false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select CustomerID from customermaster where UserName = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, UserName);
			rset = stmt.executeQuery();

			while (rset.next()) {
					if(rset.getString("CustomerID") != null) {
						result = true;
					}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return result;
	}
	
	private static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
			}
			if (stmt != null) {
				stmt.close();
			}

			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
