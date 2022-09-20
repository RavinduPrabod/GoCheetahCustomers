package com.icbtassignment.gctcs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.joda.time.DateTime;

import com.icbtassignment.gctcs.entities.BookingDetails;
import com.icbtassignment.gctcs.entities.BookingListDto;
import com.icbtassignment.gctcs.entities.CityMaster;
import com.icbtassignment.gctcs.entities.DistanceList;
import com.icbtassignment.gctcs.entities.StreetMaster;

public class BookingNowDao {
	public static List<BookingListDto> getList(DataSource dataSource, String CustomerID) {

		List<BookingListDto> oBookingList = new ArrayList<BookingListDto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT A.BookingID, C.DriverName,C.ContactNo, D.StreetName, A.PickUpLocation, A.PickUpdate,A.PickUptime,B.VehicleNo,A.VehicleType,B.Status,A.CreateDateTime FROM bookingdetails A INNER JOIN customermaster E on A.CustomerID = E.CustomerID INNER JOIN bookingheader B on A.BookingID = B.BookingID INNER JOIN drivermaster C on B.DriverID = C.DriverID INNER JOIN streetmaster D on A.StreetID = D.StreetID WHERE B.Status IN(2,3,4) AND E.CustomerID = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, CustomerID);
			rset = stmt.executeQuery();

			while (rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				String BookingDate = rset.getString("CreateDateTime");
				String DriverName = rset.getString("DriverName");
				String ContactNo = rset.getString("ContactNo");
				String StreetName = rset.getString("StreetName");
				String PickUpLocation = rset.getString("PickUpLocation");
				Date PickUpdate = rset.getDate("PickUpdate");
				Time PickUptime = rset.getTime("PickUptime");
				String VehicleNo = rset.getString("VehicleNo");
				int VehicleType = rset.getInt("VehicleType");
				int Status = rset.getInt("Status");
				DateTime CreateDateTime = null;
				DateTime ModifiedDateTime = null;
				BookingListDto oMaster = new BookingListDto(BookingID, BookingDate, DriverName, ContactNo, StreetName,
						PickUpLocation, PickUpdate, PickUptime, VehicleNo, VehicleType, Status, CreateDateTime,
						ModifiedDateTime);
				oBookingList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return oBookingList;
	}
	public static List<BookingListDto> getPENDINGList(DataSource dataSource, String CustomerID) {

		List<BookingListDto> oBookingList = new ArrayList<BookingListDto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT A.BookingID, C.DriverName,C.ContactNo, D.StreetName, A.PickUpLocation, A.PickUpdate,A.PickUptime,B.VehicleNo,A.VehicleType,F.Status,A.CreateDateTime FROM bookingdetails A INNER JOIN customermaster E on A.CustomerID = E.CustomerID INNER JOIN bookingheader B on A.BookingID = B.BookingID INNER JOIN bookingdetails F on A.BookingID = B.BookingID INNER JOIN drivermaster C on B.DriverID = C.DriverID INNER JOIN streetmaster D on A.StreetID = D.StreetID WHERE F.Status = 1 AND E.CustomerID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, CustomerID);
			rset = stmt.executeQuery();

			while (rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				String BookingDate = rset.getString("CreateDateTime");
				String DriverName = rset.getString("DriverName");
				String ContactNo = rset.getString("ContactNo");
				String StreetName = rset.getString("StreetName");
				String PickUpLocation = rset.getString("PickUpLocation");
				Date PickUpdate = rset.getDate("PickUpdate");
				Time PickUptime = rset.getTime("PickUptime");
				String VehicleNo = rset.getString("VehicleNo");
				int VehicleType = rset.getInt("VehicleType");
				int Status = rset.getInt("Status");
				DateTime CreateDateTime = null;
				DateTime ModifiedDateTime = null;
				BookingListDto oMaster = new BookingListDto(BookingID, BookingDate, DriverName, ContactNo, StreetName,
						PickUpLocation, PickUpdate, PickUptime, VehicleNo, VehicleType, Status, CreateDateTime,
						ModifiedDateTime);
				oBookingList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return oBookingList;
	}
	public static List<BookingListDto> getCOMPLETEList(DataSource dataSource, String CustomerID) {

		List<BookingListDto> oBookingList = new ArrayList<BookingListDto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "SELECT A.BookingID, C.DriverName,C.ContactNo, D.StreetName, A.PickUpLocation, A.PickUpdate,A.PickUptime,B.VehicleNo,A.VehicleType,B.Status,A.CreateDateTime FROM bookingdetails A INNER JOIN customermaster E on A.CustomerID = E.CustomerID INNER JOIN bookingheader B on A.BookingID = B.BookingID INNER JOIN drivermaster C on B.DriverID = C.DriverID INNER JOIN streetmaster D on A.StreetID = D.StreetID WHERE B.Status = 5 AND E.CustomerID = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, CustomerID);
			rset = stmt.executeQuery();

			while (rset.next()) {
				Integer BookingID = rset.getInt("BookingID");
				String BookingDate = rset.getString("CreateDateTime");
				String DriverName = rset.getString("DriverName");
				String ContactNo = rset.getString("ContactNo");
				String StreetName = rset.getString("StreetName");
				String PickUpLocation = rset.getString("PickUpLocation");
				Date PickUpdate = rset.getDate("PickUpdate");
				Time PickUptime = rset.getTime("PickUptime");
				String VehicleNo = rset.getString("VehicleNo");
				int VehicleType = rset.getInt("VehicleType");
				int Status = rset.getInt("Status");
				DateTime CreateDateTime = null;
				DateTime ModifiedDateTime = null;
				BookingListDto oMaster = new BookingListDto(BookingID, BookingDate, DriverName, ContactNo, StreetName,
						PickUpLocation, PickUpdate, PickUptime, VehicleNo, VehicleType, Status, CreateDateTime,
						ModifiedDateTime);
				oBookingList.add(oMaster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return oBookingList;
	}

	public static DistanceList get(DataSource dataSource, int id1, int id2, int VehicleType) {
		DistanceList oMaster = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select amount from distancelist where toID = ? AND fromID=? AND VehicleType=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id1);
			stmt.setInt(2, id2);
			stmt.setInt(2, VehicleType);
			rset = stmt.executeQuery();

			while (rset.next()) {
				Float amount = rset.getFloat("amount");
				oMaster = new DistanceList(0, 0, amount, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return oMaster;
	}

	public static List<CityMaster> getCityList(DataSource dataSource) {

		List<CityMaster> cities = new ArrayList<CityMaster>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select * from citymaster";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int CityID = rset.getInt("CityID");
				String CityName = rset.getString("CityName");
				CityMaster city = new CityMaster(CityID, CityName);
				cities.add(city);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return cities;
	}

	public static List<StreetMaster> getStreetList(DataSource dataSource) {

		List<StreetMaster> olist = new ArrayList<StreetMaster>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select * from streetmaster A ";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int StreetID = rset.getInt("StreetID");
				String StreetName = rset.getString("StreetName");
				int CityID = rset.getInt("CityID");
				StreetMaster slist = new StreetMaster(StreetID, StreetName, CityID);
				olist.add(slist);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}

		return olist;
	}

	public static void CreateBook(DataSource dataSource, BookingDetails oMaster) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO `bookingdetails`(`CustomerID`, `CityID`, `StreetID`, `PassengerName`, `ContactNo`, `VehicleType`, `PickUpLocation`, `PickUpdate`, `PickUptime`, `Status`, `CreateDatetime`, `ModifiedDateTime`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, oMaster.getCustomerID());
			pstmt.setInt(2, oMaster.getCityID());
			pstmt.setInt(3, oMaster.getStreetID());
			pstmt.setString(4, oMaster.getPassengerName());
			pstmt.setString(5, oMaster.getContactNo());
			pstmt.setInt(6, oMaster.getVehicleType());
			pstmt.setString(7, oMaster.getPickUpLocation());
			pstmt.setDate(8, oMaster.getPickUpdate());
			pstmt.setString(9, oMaster.getPickUptime());
			pstmt.setInt(10, oMaster.getStatus());
			pstmt.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, null);
		}
	}

	public static float getTravelCost(DataSource dataSource, int VehicleType) {

		float tcost = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;

		try {
			con = dataSource.getConnection();
			sql = "select * from vehiclemaster where VehicleType = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, VehicleType);
			rset = stmt.executeQuery();

			while (rset.next()) {
				tcost = rset.getFloat("AmountperKM");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(con, stmt, null);
		}
		return tcost;
	}

	public static BookingDetails getVehicleList(DataSource dataSource, int vehiclecategoryId) {

		BookingDetails vehiclecategories = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;
		try {
			con = dataSource.getConnection();
			sql = "select VehicleType,AmountperKM from vehiclemaster where VehicleType=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vehiclecategoryId);
			rset = stmt.executeQuery();

			while (rset.next()) {
				int vehicle_category_Id;

				vehicle_category_Id = rset.getInt("VehicleType");
				float charge_per_Km = rset.getFloat("AmountperKM");
				vehiclecategories = new BookingDetails(vehicle_category_Id, charge_per_Km);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return vehiclecategories;
	}
	public static String getRate(DataSource dataSource, int vehiclecategoryId) {
		
		String Charge_per_Km = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		String sql = null;
		try {
			con = dataSource.getConnection();
			sql = "select VehicleType,AmountperKM from vehiclemaster where VehicleType=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vehiclecategoryId);
			rset = stmt.executeQuery();

			while (rset.next()) {
				//vehicle_category_Id = rset.getInt("VehicleType");
				Charge_per_Km = String.valueOf(rset.getFloat("AmountperKM"));
				//vehiclecategories = new BookingDetails(vehicle_category_Id, charge_per_Km);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return Charge_per_Km;
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
