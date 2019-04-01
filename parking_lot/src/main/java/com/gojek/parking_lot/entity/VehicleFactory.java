package com.gojek.parking_lot.entity;

import com.gojek.parking_lot.utils.Constants.VehicleType;
import com.gojek.parking_lot.utils.VechicleRepository;

public class VehicleFactory {

	public Vehicle getVehicle(VehicleType vehicleType, String registrationNumber, String color) {
		Vehicle vehicle = VechicleRepository.vehicleMap.get(vehicleType);
		vehicle = vehicle.initializeVehicle(registrationNumber, color);
		return vehicle;
	}

}
