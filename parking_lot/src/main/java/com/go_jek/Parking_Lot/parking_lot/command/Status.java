package com.go_jek.Parking_Lot.parking_lot.command;

import com.go_jek.Parking_Lot.parking_lot.service.ParkingService;

public class Status implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public void execute(String[] args) {
		service.status();
	}

}
