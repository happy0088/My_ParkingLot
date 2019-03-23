package main.com.gojek.parking_lot.command;

import main.com.gojek.parking_lot.service.ParkingService;

public class UnParkVehicle implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public void execute(String[] args) {
		service.leave(args[1]);
	}

}
