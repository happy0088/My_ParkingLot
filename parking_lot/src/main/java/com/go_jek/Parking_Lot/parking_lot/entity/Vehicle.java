package com.go_jek.Parking_Lot.parking_lot.entity;

public abstract class Vehicle {
	protected String registrationNumber;
	protected int spotsNeeded;
	protected String color;
	
	public abstract Vehicle initializeVehicle(String registrationNumber, String color) ;

	public abstract boolean canFitInSpot(ParkingSpot spot);

	public abstract void printVehicleDetails();

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