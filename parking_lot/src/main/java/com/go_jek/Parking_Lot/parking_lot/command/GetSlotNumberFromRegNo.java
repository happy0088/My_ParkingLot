package main.com.gojek.parking_lot.command;

import main.com.gojek.parking_lot.service.ParkingService;

public class GetSlotNumberFromRegNo implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public void execute(String[] args) {
		service.getSlotNumberFromRegNo(args[1]);
	}

}
