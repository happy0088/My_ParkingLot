package com.go_jek.parking_lot.command;

import com.go_jek.parking_lot.entity.Vehicle;
import com.go_jek.parking_lot.entity.VehicleFactory;
import com.go_jek.parking_lot.exception.InvalidInputException;
import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.service.TicketService;
import com.go_jek.parking_lot.utils.Constants;
import com.go_jek.parking_lot.utils.Printer;

public class ParkVehicle implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public String execute(String[] args) throws InvalidInputException {
		try {
			String outPutMessage = "";
			String regNumber = args[1];
			String color = args[2];
			// service.park(args[1], args[2], Constants.DEFAULT_VEHICLE);
			if (ParkingService.availableSlots == null) {
				outPutMessage = Constants.PARKING_LOT_UNAVAILABLE;
				Printer.printMessage(outPutMessage, true);
				return outPutMessage;
			}
			if (!ParkingService.availableSlots.isEmpty()) {
				Vehicle vehicle = new VehicleFactory().getVehicle(Constants.DEFAULT_VEHICLE, regNumber, color);
				parkVehicle(vehicle);
				int location = ParkingService.availableSlots.first();
				ParkingService.registrationSlotMap.put(vehicle.getRegistrationNumber(), location);
				ParkingService.registrationColorMap.put(vehicle.getRegistrationNumber(), vehicle.getColor());
				outPutMessage = Constants.ALLOCATED_SLOT_NUMBER + location;
				Printer.printMessage(outPutMessage, true);
				ParkingService.availableSlots.remove(location);
				TicketService.issueTicket(vehicle);
				return vehicle.getRegistrationNumber();
			} else {
				outPutMessage = Constants.PARKING_FULL;
				Printer.printMessage(Constants.PARKING_FULL, true);
			}
			return outPutMessage;
		} catch (Exception ex) {
			throw new InvalidInputException(Constants.INPUT_ERROR);
		}
	}

	public boolean parkVehicle(Vehicle vehicle) {
		for (int i = 0; i < ParkingService.parkingLot.levels.length; i++) {
			if (ParkingService.parkingLot.levels[i].parkVehicle(vehicle)) {
				return true;
			}
		}
		return false;
	}

}
