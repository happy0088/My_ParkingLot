package com.gojek.parking_lot.command;

import java.util.Map.Entry;

import com.gojek.parking_lot.exception.InvalidInputException;
import com.gojek.parking_lot.service.ParkingService;
import com.gojek.parking_lot.utils.Constants;
import com.gojek.parking_lot.utils.Printer;

public class GetRegistrationNumbersFromColor implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public String execute(String[] args) throws InvalidInputException {
		try {
			String outPutMessage = "";
			String color = args[1];
			if (ParkingService.availableSlots == null) {
				outPutMessage = Constants.PARKING_LOT_UNAVAILABLE;
				Printer.printMessage(outPutMessage, true);
				return outPutMessage;
			}
			int count = 1;
			String registrations = Constants.EMPTY_STRING;
			for (Entry<String, String> entry : ParkingService.registrationColorMap.entrySet()) {
				if (entry.getValue().equals(color)) {
					if (count > 1) {
						outPutMessage = ", ";
						Printer.printMessage(outPutMessage, false);
					}
					outPutMessage = entry.getKey();
					Printer.printMessage(outPutMessage, false);
					count++;
					registrations += entry.getKey();
				}
			}
			if (count == 1) {
				Printer.printMessage(Constants.NOT_FOUND, true);
			} else {
				Printer.printMessage(Constants.EMPTY_STRING, true);
			}
			return registrations;
		} catch (Exception ex) {
			throw new InvalidInputException(Constants.INPUT_ERROR);
		}
	}

}
