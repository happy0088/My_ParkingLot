package com.go_jek.parking_lot.command;

import com.go_jek.parking_lot.exception.InvalidInputException;
import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.utils.Constants;
import com.go_jek.parking_lot.utils.Printer;

public class GetSlotNumberFromRegNo implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public String execute(String[] args) throws InvalidInputException {
		try {
			// service.getSlotNumberFromRegNo(args[1]);
			String registrationNumber = args[1];
			if (ParkingService.availableSlots == null) {
				Printer.printMessage(Constants.PARKING_LOT_UNAVAILABLE, true);
				return "0";
			}
			Integer regNumber = ParkingService.registrationSlotMap.get(registrationNumber);
			if (regNumber == null) {
				Printer.printMessage(Constants.NOT_FOUND, true);
				return "0";
			} else {
				Printer.printMessage(regNumber.toString(), true);
				return regNumber.toString();
			}
		} catch (Exception ex) {
			throw new InvalidInputException(Constants.INPUT_ERROR);
		}
	}

}
