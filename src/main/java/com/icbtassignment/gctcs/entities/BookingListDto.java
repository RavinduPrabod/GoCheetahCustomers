package com.icbtassignment.gctcs.entities;

import java.sql.Date;
import java.sql.Time;

import org.joda.time.DateTime;

public class BookingListDto {
	
	private int BookingID;
	
	private String BookingDate;

	private String DriverName;
	
	private String ContactNo;
	
	private String StreetName;
	
	private String PickUpLocation;
	
	private Date PickUpdate;
	
	private Time PickUptime;
	
	private String VehicleNo;
	
	private int VehicleType;
	
	private int Status;

	private DateTime CreateDatetime;

	private DateTime ModifiedDateTime;

	public BookingListDto(int BookingID,String BookingDate,String DriverName,String ContactNo,String StreetName,String PickUpLocation,
			Date PickUpdate, Time PickUptime,String VehicleNo,int VehicleType,int Status,
			DateTime CreateDatetime, DateTime ModifiedDateTime) {
		super();
		this.BookingID = BookingID;
		this.BookingDate = BookingDate;
		this.DriverName = DriverName;
		this.ContactNo = ContactNo;
		this.StreetName = StreetName;
		this.PickUpLocation = PickUpLocation;
		this.PickUpdate = PickUpdate;
		this.PickUptime = PickUptime;	
		this.VehicleNo = VehicleNo;
		this.VehicleType = VehicleType;
		this.Status = Status;
		this.CreateDatetime = CreateDatetime;
		this.ModifiedDateTime = ModifiedDateTime;
	}

	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingID) {
		BookingID = bookingID;
	}

	public String getBookingDate() {
		return BookingDate;
	}

	public void setBookingDate(String bookingDate) {
		BookingDate = bookingDate;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
	}

	public String getContactNo() {
		return ContactNo;
	}

	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public String getPickUpLocation() {
		return PickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		PickUpLocation = pickUpLocation;
	}

	public Date getPickUpdate() {
		return PickUpdate;
	}

	public void setPickUpdate(Date pickUpdate) {
		PickUpdate = pickUpdate;
	}

	public Time getPickUptime() {
		return PickUptime;
	}

	public void setPickUptime(Time pickUptime) {
		PickUptime = pickUptime;
	}

	public String getVehicleNo() {
		return VehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}

	public int getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(int vehicleType) {
		VehicleType = vehicleType;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public DateTime getCreateDatetime() {
		return CreateDatetime;
	}

	public void setCreateDatetime(DateTime createDatetime) {
		CreateDatetime = createDatetime;
	}

	public DateTime getModifiedDateTime() {
		return ModifiedDateTime;
	}

	public void setModifiedDateTime(DateTime modifiedDateTime) {
		ModifiedDateTime = modifiedDateTime;
	}
	
	
}
