package com.icbtassignment.gctcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.sql.DataSource;

import com.icbtassignment.gctcs.entities.CustomerMaster;

public class CustomerMasterDao {
	
	public static void AddNew(DataSource dataSource, CustomerMaster oMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into customermaster (CustomerID,FirstName,LastName,City,MobileNo,Email,UserName,Password,CreateDateTime,ModifiedDateTime) values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, oMaster.getCustomerID());
			pstmt.setString(2, oMaster.getFirstName());
			pstmt.setString(3, oMaster.getLastName());
			pstmt.setString(4, oMaster.getCity());
			pstmt.setString(5, oMaster.getMobileNo());
			pstmt.setString(6, oMaster.getEmail());
			pstmt.setString(7, oMaster.getUserName());
			pstmt.setString(8, oMaster.getPassword());
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(con,pstmt,null);
		}	
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
