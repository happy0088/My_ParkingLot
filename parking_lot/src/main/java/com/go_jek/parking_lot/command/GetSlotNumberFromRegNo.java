package com.go_jek.parking_lot.command;

import com.go_jek.parking_lot.exception.InvalidInputException;
import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.utils.Constants;

public class GetSlotNumberFromRegNo implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public void execute(String[] args) throws InvalidInputException {
		try {
			service.getSlotNumberFromRegNo(args[1]);
		} catch (Exception ex) {
			throw new InvalidInputException(Constants.INPUT_ERROR);
		}
	}

}
