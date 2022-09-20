package com.icbtassignment.gctcs.entities;

import javax.validation.constraints.NotBlank;

import org.joda.time.DateTime;

public class CityMaster {
	
	
	private int CityID;
	
	@NotBlank(message = "is required")
	private String CityName;
	
	private DateTime CreateDateTime;
	
	private DateTime ModifiedDateTime;
	
	public CityMaster(int CityID, String CityName) {
		this.CityID = CityID;
		this.CityName = CityName;
	}
	
	public CityMaster(int CityID, String CityName,DateTime CreateDateTime, DateTime ModifiedDateTime) {
		super();
		this.CityID = CityID;
		this.CityName = CityName;
		this.CreateDateTime = CreateDateTime;
		this.ModifiedDateTime = ModifiedDateTime;
	}

	public int getCityID() {
		return CityID;
	}

	public void setCityID(int cityID) {
		CityID = cityID;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
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
