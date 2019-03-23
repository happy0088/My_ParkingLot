package com.go_jek.Parking_Lot.parking_lot.utils;

import java.util.HashMap;
import java.util.Map;

import com.go_jek.Parking_Lot.parking_lot.entity.Car;
import com.go_jek.Parking_Lot.parking_lot.entity.MotorCycle;
import com.go_jek.Parking_Lot.parking_lot.entity.Vehicle;
import com.go_jek.Parking_Lot.parking_lot.utils.Constants.VehicleType;

public class VechicleRepository {

	public Map<VehicleType, Vehicle> vehicleMap;
	Vehicle car = new Car();
	Vehicle motorcycle = new MotorCycle();

	public VechicleRepository() {
		vehicleMap = new HashMap<VehicleType, Vehicle>();
		try {
			populateVehicleHashMap();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	private void populateVehicleHashMap() throws NoSuchMethodException {
		vehicleMap.put(VehicleType.CAR, car);
		vehicleMap.put(VehicleType.MOTORCYCLE, motorcycle);

	}
}
