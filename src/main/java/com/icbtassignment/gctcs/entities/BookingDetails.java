package com.icbtassignment.gctcs.entities;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;

public class BookingDetails {

	@NotBlank(message = "is required")
	private int BookingID;

	@NotBlank(message = "is required")
	private String CustomerID;

	@NotBlank(message = "is required")
	private int CityID;

	@NotBlank(message = "is required")
	private int StreetID;

	@NotBlank(message = "is required")
	private String PassengerName;

	@NotBlank(message = "is required")
	private String ContactNo;

	@NotBlank(message = "is required")
	private int VehicleType;

	@NotBlank(message = "is required")
	private String PickUpLocation;

	@NotBlank(message = "is required")
	private Date PickUpdate;

	@NotBlank(message = "is required")
	private String PickUptime;

	@NotBlank(message = "is required")
	private int Status;
	
	@NotBlank(message = "is required")
	private float AmountperKM;

	private DateTime CreateDatetime;

	private DateTime ModifiedDateTime;

	public BookingDetails(int BookingID, String CustomerID, int CityID, int StreetID, String PassengerName,
			String ContactNo, int VehicleType, String PickUpLocation, Date PickUpdate, String PickUptime, int Status,
			DateTime CreateDatetime, DateTime ModifiedDateTime) {
		super();
		this.BookingID = BookingID;
		this.CustomerID = CustomerID;
		this.CityID = CityID;
		this.StreetID = StreetID;
		this.PassengerName = PassengerName;
		this.ContactNo = ContactNo;
		this.VehicleType = VehicleType;
		this.PickUpLocation = PickUpLocation;
		this.PickUpdate = PickUpdate;
		this.PickUptime = PickUptime;
		this.Status = Status;
		this.CreateDatetime = CreateDatetime;
		this.ModifiedDateTime = ModifiedDateTime;
	}
	

	public BookingDetails( int vehicleType,float amountperKM) {
		super();
		VehicleType = vehicleType;
		AmountperKM = amountperKM;
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

	public int getCityID() {
		return CityID;
	}

	public void setCityID(int cityID) {
		CityID = cityID;
	}

	public int getStreetID() {
		return StreetID;
	}

	public void setStreetID(int streetID) {
		StreetID = streetID;
	}

	public String getPassengerName() {
		return PassengerName;
	}

	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}

	public String getContactNo() {
		return ContactNo;
	}

	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}

	public int getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(int vehicleType) {
		VehicleType = vehicleType;
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

	public String getPickUptime() {
		return PickUptime;
	}

	public void setPickUptime(String pickUptime) {
		PickUptime = pickUptime;
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


	public float getAmountperKM() {
		return AmountperKM;
	}


	public void setAmountperKM(float amountperKM) {
		AmountperKM = amountperKM;
	}

}
