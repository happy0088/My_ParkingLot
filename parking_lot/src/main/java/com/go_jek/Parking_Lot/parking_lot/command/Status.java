package main.com.gojek.parking_lot.command;

import main.com.gojek.parking_lot.service.ParkingService;

public class Status implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public void execute(String[] args) {
		service.status();
	}

}
