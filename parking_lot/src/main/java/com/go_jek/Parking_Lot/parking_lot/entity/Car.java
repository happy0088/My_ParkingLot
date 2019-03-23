package com.go_jek.Parking_Lot.parking_lot.entity;

import com.go_jek.Parking_Lot.parking_lot.utils.Printer;

public class Car extends Vehicle {
	public static final Car BASE_INSTANCE = new Car();

	private Car() {

	}

	public Vehicle initializeVehicle(String registrationNumber, String color) {
		BASE_INSTANCE.setRegistrationNumber(registrationNumber);
		BASE_INSTANCE.setColor(color);
		BASE_INSTANCE.setSpotsNeeded(1);
		return BASE_INSTANCE;
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