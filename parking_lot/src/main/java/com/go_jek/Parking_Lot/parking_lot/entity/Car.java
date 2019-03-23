package com.go_jek.Parking_Lot.parking_lot.entity;

import com.go_jek.Parking_Lot.parking_lot.utils.Printer;

public class Car extends Vehicle {
	public static final Car BASE_INSTANCE = new Car();

	public Car() {

	}

	public Car(String registrationNumber, String color) {
		spotsNeeded = 1;
		this.registrationNumber = registrationNumber;
		this.color = color;
	}

	public boolean canFitInSpot(ParkingSpot spot) {
		return true;
	}

	@Override
	public void printVehicleDetails() {
		Printer.printMessage("FourWheeler [registrationNumber=" + registrationNumber + ", spotsNeeded=" + spotsNeeded
				+ ", color=" + color + "]", true);
	}

	@Override
	public String toString() {
		return "FourWheeler [registrationNumber=" + registrationNumber + ", spotsNeeded=" + spotsNeeded + ", color="
				+ color + "]";
	}
}