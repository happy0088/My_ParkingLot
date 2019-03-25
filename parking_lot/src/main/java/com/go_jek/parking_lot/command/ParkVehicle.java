package com.go_jek.parking_lot.command;

import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.utils.Constants;

public class ParkVehicle implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public void execute(String[] args) {
		service.park(args[1], args[2],Constants.DEFAULT_VEHICLE);
	}

}
