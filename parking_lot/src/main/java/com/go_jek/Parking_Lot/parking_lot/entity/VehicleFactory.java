package com.go_jek.Parking_Lot.parking_lot.entity;

import com.go_jek.Parking_Lot.parking_lot.utils.Constants.VehicleType;

public class VehicleFactory {

	public Vehicle getVehicle(VehicleType vehicleType, String registrationNumber, String color) {
		// can be upgraded to return two-wheeler , buses etc as sub classes of vehicle .
		return new Car(registrationNumber, color);
	}

}
