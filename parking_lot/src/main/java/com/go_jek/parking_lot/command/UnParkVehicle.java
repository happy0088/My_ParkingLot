package com.go_jek.parking_lot.command;

import com.go_jek.parking_lot.service.ParkingService;

public class UnParkVehicle implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public void execute(String[] args) {
		service.leave(args[1]);
	}

}