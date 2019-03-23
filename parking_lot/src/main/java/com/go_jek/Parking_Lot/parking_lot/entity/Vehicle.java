package main.com.gojek.parking_lot.entity;

public abstract class Vehicle {
	protected String registrationNumber;
	protected int spotsNeeded;
	protected String color;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSpotsNeeded(int spotsNeeded) {
		this.spotsNeeded = spotsNeeded;
	}

	public int getSpotsNeeded() {
		return spotsNeeded;
	}

	public abstract boolean canFitInSpot(ParkingSpot spot);

	public abstract void printVehicleDetails();
}