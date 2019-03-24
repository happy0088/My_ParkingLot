package com.go_jek.Parking_Lot.parking_lot.entity;

import com.go_jek.Parking_Lot.parking_lot.utils.Constants.ParkingSpotType;
import com.go_jek.Parking_Lot.parking_lot.utils.Printer;

public class MotorCycle extends Vehicle {

	public static final MotorCycle BASE_INSTANCE = new MotorCycle();

	public MotorCycle() {

	}

	public Vehicle initializeVehicle(String registrationNumber, String color) {
		return new MotorCycle(registrationNumber, color);
	}

	public MotorCycle(String registrationNumber, String color) {
		this.color = color;
		this.registrationNumber = registrationNumber;
		this.spotsNeeded = 1;
		this.parkingSpotType = ParkingSpotType.SMALL;
	}

	public boolean canFitInSpot(ParkingSpot spot) {
		return true;
	}

	@Override
	public void printVehicleDetails() {
		Printer.printMessage("TwoWheeler [registrationNumber=" + registrationNumber + ", spotsNeeded=" + spotsNeeded
				+ ", color=" + color + "]", true);
	}

	@Override
	public String toString() {
		return "TwoWheeler [registrationNumber=" + registrationNumber + ", spotsNeeded=" + spotsNeeded + ", color="
				+ color + "]";
	}
}