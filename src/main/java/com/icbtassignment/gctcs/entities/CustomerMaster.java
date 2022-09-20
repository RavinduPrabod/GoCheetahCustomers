package com.icbtassignment.gctcs.entities;

import java.sql.Date;
import java.sql.Time;

import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;

public class CustomerMaster {
	
	@NotBlank(message = "is required")
	private String CustomerID;
	@NotBlank(message = "is required")
	private String FirstName;
	@NotBlank(message = "is required")
	private String LastName;
	@NotBlank(message = "is required")
	private String City;
	@NotBlank(message = "is required")
	private String MobileNo;
	@NotBlank(message = "is required")
	private String Email;
	@NotBlank(message = "is required")
	private String UserName;
	@NotBlank(message = "is required")
	private String Password;
	@NotBlank(message = "is required")
	private DateTime CreateDateTime;
	@NotBlank(message = "is required")
	private DateTime ModifiedDateTime;	
	
	public CustomerMaster(String CustomerID, String FirstName, String LastName, String City, String MobileNo, String Email, String UserName, String Password
			,DateTime CreateDatetime, DateTime ModifiedDateTime) {
		super();
		this.CustomerID = CustomerID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.City = City;
		this.MobileNo = MobileNo;
		this.Email = Email;
		this.UserName = UserName;
		this.Password = Password;
		this.CreateDateTime = CreateDatetime;
		this.ModifiedDateTime = ModifiedDateTime;
	}
	public CustomerMaster(String CustomerID, String FirstName, String LastName, String City, String MobileNo, String Password) {
		this.CustomerID = CustomerID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.City = City;
		this.MobileNo = MobileNo;
		this.Password = Password;
	}
	
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public DateTime getCreateDateTime() {
		return CreateDateTime;
	}
	public void setCreateDateTime(DateTime createDateTime) {
		CreateDateTime = createDateTime;
	}
	public DateTime getModifiedDateTime() {
		return ModifiedDateTime;
	}
	public void setModifiedDateTime(DateTime modifiedDateTime) {
		ModifiedDateTime = modifiedDateTime;
	}
	
}
