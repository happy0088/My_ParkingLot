package com.gojek.parking_lot.entity;

import com.gojek.parking_lot.utils.Constants.ParkingSpotType;

public abstract class Vehicle {
	protected String registrationNumber;
	protected int spotsNeeded;
	protected String color;
	protected ParkingSpotType parkingSpotType;

	public abstract Vehicle initializeVehicle(String registrationNumber, String color);

	public abstract boolean canFitInSpot(ParkingSpot spot);

	public abstract void printVehicleDetails();

	public ParkingSpotType getParkingSpotType() {
		return parkingSpotType;
	}

	public void setParkingSpotType(ParkingSpotType parkingSpotType) {
		this.parkingSpotType = parkingSpotType;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getSpotsNeeded() {
		return spotsNeeded;
	}

	public void setSpotsNeeded(int spotsNeeded) {
		this.spotsNeeded = spotsNeeded;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}