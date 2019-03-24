package com.go_jek.Parking_Lot.parking_lot.utils;

import java.util.HashMap;
import java.util.Map;

import com.go_jek.Parking_Lot.parking_lot.command.CommandController;
import com.go_jek.Parking_Lot.parking_lot.command.CreateParkingLot;
import com.go_jek.Parking_Lot.parking_lot.command.GetRegistrationNumbersFromColor;
import com.go_jek.Parking_Lot.parking_lot.command.GetSlotNumberFromRegNo;
import com.go_jek.Parking_Lot.parking_lot.command.GetSlotNumbersFromColor;
import com.go_jek.Parking_Lot.parking_lot.command.ICommand;
import com.go_jek.Parking_Lot.parking_lot.command.ParkVehicle;
import com.go_jek.Parking_Lot.parking_lot.command.Status;
import com.go_jek.Parking_Lot.parking_lot.command.UnParkVehicle;

public class CommandRepository {

	public Map<String, ICommand> commandsMap;
	CommandController controller = new CommandController();
	ICommand parkVechicle = new ParkVehicle();
	ICommand unparkVehicle = new UnParkVehicle();
	ICommand createParkingLot = new CreateParkingLot();
	ICommand status = new Status();
	ICommand getRegistrationNumbersFromColor = new GetRegistrationNumbersFromColor();
	ICommand getSlotNumbersFromColor = new GetSlotNumbersFromColor();
	ICommand getSlotNumberFromRegNo = new GetSlotNumberFromRegNo();

	public CommandRepository() {
		commandsMap = new HashMap<String, ICommand>();
		try {
			populateCommandsHashMap();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	private void populateCommandsHashMap() throws NoSuchMethodException {
		commandsMap.put(Constants.CREATE_PARKING_LOT, createParkingLot);
		commandsMap.put(Constants.PARK, parkVechicle);
		commandsMap.put(Constants.LEAVE, unparkVehicle);
		commandsMap.put(Constants.STATUS, status);
		commandsMap.put(Constants.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR, getRegistrationNumbersFromColor);
		commandsMap.put(Constants.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR, getSlotNumbersFromColor);
		commandsMap.put(Constants.SLOT_NUMBER_FOR_REGISTRATION_NUMBER, getSlotNumberFromRegNo);

	}
}
