package com.go_jek.parking_lot.command;

import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.utils.Constants;
import com.go_jek.parking_lot.utils.Printer;

public class ParkVehicle implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public void execute(String[] args) {
		if (args.length > 1) {
			service.park(args[1], args[2], Constants.DEFAULT_VEHICLE);
		} else {
			Printer.printMessage(Constants.INPUT_ERROR, true);
		}
	}

}
