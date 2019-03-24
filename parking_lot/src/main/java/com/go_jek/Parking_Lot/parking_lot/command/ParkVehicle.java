package com.go_jek.Parking_Lot.parking_lot.command;

import com.go_jek.Parking_Lot.parking_lot.service.ParkingService;

public class ParkVehicle implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public void execute(String[] args) {
		service.park(args[1], args[2]);
	}

}
