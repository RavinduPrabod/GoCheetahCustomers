package com.icbtassignment.gctcs.entities;

import javax.validation.constraints.NotBlank;


public class DistanceList {


	@NotBlank(message = "is required")
	private int toID ;
	
	@NotBlank(message = "is required")
	private int fromID ;
	
	@NotBlank(message = "is required")
	private Float amount;	
	
	@NotBlank(message = "is required")
	private int VehicleType ;
	
	public DistanceList(int toID ,	int fromID , Float amount, int VehicleType) 
	{
		super();
		this.toID  = toID ;
		this.fromID  = fromID ;
		this.amount = amount;
		this.VehicleType = VehicleType;
		}


	public int getToID() {
		return toID;
	}


	public void setToID(int toID) {
		this.toID = toID;
	}


	public int getFromID() {
		return fromID;
	}


	public void setFromID(int fromID) {
		this.fromID = fromID;
	}


	public Float getAmount() {
		return amount;
	}


	public void setAmount(Float amount) {
		this.amount = amount;
	}


	public int getVehicleType() {
		return VehicleType;
	}


	public void setVehicleType(int vehicleType) {
		VehicleType = vehicleType;
	}

}
