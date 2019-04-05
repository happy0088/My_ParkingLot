package com.gojek.parking_lot.command;

import com.gojek.parking_lot.exception.InvalidInputException;
import com.gojek.parking_lot.service.ParkingService;
import com.gojek.parking_lot.utils.Constants;
import com.gojek.parking_lot.utils.Printer;

public class CreateParkingLot implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public String execute(String[] args) throws InvalidInputException {
		try {
			int slotSize = Integer.parseInt(args[1]);
			int size = ParkingService.allocateFreeSlots(slotSize, Constants.DEFAULT_LEVEL_COUNT);
			String outPutMessage = Constants.CREATED_PARKING_LOT_WITH + size + Constants.SLOTS;
			Printer.printMessage(outPutMessage, true);
			return outPutMessage;
		} catch (Exception ex) {
			throw new InvalidInputException(Constants.INPUT_ERROR);
		}
	}

}
