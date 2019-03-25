package com.go_jek.parking_lot.command;

import java.util.Map.Entry;

import com.go_jek.parking_lot.exception.InvalidInputException;
import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.utils.Constants;
import com.go_jek.parking_lot.utils.Printer;

public class UnParkVehicle implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public String execute(String[] args) throws InvalidInputException {
		try {
			String outPutMessage = "";
			String spot = args[1];
			if (ParkingService.availableSlots == null) {
				Printer.printMessage(Constants.PARKING_LOT_UNAVAILABLE, true);
				return "0";
			}
			for (Entry<String, Integer> entry : ParkingService.registrationSlotMap.entrySet()) {
				int spotNUmber = Integer.parseInt(spot);
				if (entry.getValue() == (Integer.parseInt(spot))) {
					unParkVehicle(spotNUmber, entry.getKey());
					outPutMessage = "Slot number " + spot + " is free";
					Printer.printMessage(outPutMessage, true);
					return spot;
				}
			}
			return "0";
		} catch (Exception ex) {
			throw new InvalidInputException(Constants.INPUT_ERROR);
		}
	}

	public boolean unParkVehicle(int spotNumber, String regNumber) {
		for (int i = 0; i < ParkingService.parkingLot.levels.length; i++) {
			if (ParkingService.parkingLot.levels[i].unParkVehicle(spotNumber)) {
				ParkingService.registrationColorMap.remove(regNumber);
				ParkingService.registrationSlotMap.values().remove(spotNumber);
				ParkingService.availableSlots.add(spotNumber);
				return true;
			}
		}
		return false;
	}
}
