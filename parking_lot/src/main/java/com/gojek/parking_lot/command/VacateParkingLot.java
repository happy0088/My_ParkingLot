package com.gojek.parking_lot.command;

import com.gojek.parking_lot.exception.InvalidInputException;
import com.gojek.parking_lot.service.ParkingService;
import com.gojek.parking_lot.utils.Constants;

public class VacateParkingLot implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public String execute(String[] args) throws InvalidInputException {
		try {
			ParkingService.availableSlots.clear();
			ParkingService.registrationColorMap.clear();
			ParkingService.registrationSlotMap.clear();
			return null;
		} catch (Exception ex) {
			throw new InvalidInputException(Constants.INPUT_ERROR);
		}
	}

}
