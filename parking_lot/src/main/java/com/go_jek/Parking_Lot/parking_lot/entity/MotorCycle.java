package main.com.gojek.parking_lot.entity;

import main.com.gojek.parking_lot.utils.Printer;

public class MotorCycle extends Vehicle {

	public static final MotorCycle BASE_INSTANCE = new MotorCycle();

	public MotorCycle() {

	}

	public MotorCycle(String registrationNumber, String color) {
		spotsNeeded = 1;
		this.registrationNumber = registrationNumber;
		this.color = color;
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