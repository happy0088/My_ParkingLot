package com.go_jek.parking_lot.utils;

import java.util.HashMap;
import java.util.Map;

import com.go_jek.parking_lot.entity.Car;
import com.go_jek.parking_lot.entity.MotorCycle;
import com.go_jek.parking_lot.entity.Vehicle;
import com.go_jek.parking_lot.utils.Constants.VehicleType;

public class VechicleRepository {

	public static final Map<VehicleType, Vehicle> vehicleMap = new HashMap<VehicleType, Vehicle>() {
		{
			put(VehicleType.CAR, Car.BASE_INSTANCE);
			put(VehicleType.MOTORCYCLE, MotorCycle.BASE_INSTANCE);
		}
	};
}
