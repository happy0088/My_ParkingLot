package com.go_jek.parking_lot.command;

import com.go_jek.parking_lot.service.ParkingService;

public class GetSlotNumberFromRegNo implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public void execute(String[] args) {
		service.getSlotNumberFromRegNo(args[1]);
	}

}
