package com.icbtassignment.gctcs.entities;

import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;

public class BookingHeader {

	@NotBlank(message = "is required")
	private int BookingID;
	
	@NotBlank(message = "is required")
	private String CustomerID;
	
	@NotBlank(message = "is required")
	private int DriverID;	
	
	@NotBlank(message = "is required")
	private String VehicleNo;	
	
	@NotBlank(message = "is required")
	private int BranchID;
	
	@NotBlank(message = "is required")
	private int VehicleType;
	
	@NotBlank(message = "is required")
	private String FromLocationAddress;
	
	@NotBlank(message = "is required")
	private String ToLocationAddress;
	
	private DateTime CreateDatetime;
	
	private DateTime ModifiedDateTime;
	
	public BookingHeader(int BookingID,	String CustomerID, int DriverID, String VehicleNo,	int BranchID, int VehicleType, String FromLocationAddress,	String ToLocationAddress, DateTime	CreateDatetime, DateTime ModifiedDateTime) 
	{
		super();
		this.BookingID = BookingID;
		this.CustomerID = CustomerID;
		this.DriverID = DriverID;
		this.VehicleNo = VehicleNo;
		this.BranchID = BranchID;
		this.VehicleNo = VehicleNo;
		this.VehicleType = VehicleType;	
		this.FromLocationAddress = FromLocationAddress;
		this.ToLocationAddress = ToLocationAddress;
		this.CreateDatetime = CreateDatetime;
		this.ModifiedDateTime = ModifiedDateTime;
	}

	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingID) {
		BookingID = bookingID;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public int getDriverID() {
		return DriverID;
	}

	public void setDriverID(int driverID) {
		DriverID = driverID;
	}

	public String getVehicleNo() {
		return VehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}

	public int getBranchID() {
		return BranchID;
	}

	public void setBranchID(int branchID) {
		BranchID = branchID;
	}

	public int getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(int vehicleType) {
		VehicleType = vehicleType;
	}

	public String getFromLocationAddress() {
		return FromLocationAddress;
	}

	public void setFromLocationAddress(String fromLocationAddress) {
		FromLocationAddress = fromLocationAddress;
	}

	public String getToLocationAddress() {
		return ToLocationAddress;
	}

	public void setToLocationAddress(String toLocationAddress) {
		ToLocationAddress = toLocationAddress;
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
