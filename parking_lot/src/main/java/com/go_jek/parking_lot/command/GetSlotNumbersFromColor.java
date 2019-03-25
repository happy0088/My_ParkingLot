package com.go_jek.parking_lot.command;

import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.utils.Constants;
import com.go_jek.parking_lot.utils.Printer;

public class GetSlotNumbersFromColor implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public void execute(String[] args) {
		if (args.length > 0) {
			service.getSlotNumbersFromColor(args[1]);
		} else {
			Printer.printMessage(Constants.INPUT_ERROR, true);
		}
	}

}
