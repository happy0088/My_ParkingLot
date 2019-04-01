package com.gojek.parking_lot.utils;

import java.util.HashMap;
import java.util.Map;

import com.gojek.parking_lot.command.CommandController;
import com.gojek.parking_lot.command.CreateParkingLot;
import com.gojek.parking_lot.command.GetRegistrationNumbersFromColor;
import com.gojek.parking_lot.command.GetSlotNumberFromRegNo;
import com.gojek.parking_lot.command.GetSlotNumbersFromColor;
import com.gojek.parking_lot.command.ICommand;
import com.gojek.parking_lot.command.ParkVehicle;
import com.gojek.parking_lot.command.Status;
import com.gojek.parking_lot.command.UnParkVehicle;

public class CommandRepository {

	CommandController controller = new CommandController();
	static ICommand parkVechicle = new ParkVehicle();
	static ICommand unparkVehicle = new UnParkVehicle();
	static ICommand createParkingLot = new CreateParkingLot();
	static ICommand status = new Status();
	static ICommand getRegistrationNumbersFromColor = new GetRegistrationNumbersFromColor();
	static ICommand getSlotNumbersFromColor = new GetSlotNumbersFromColor();
	static ICommand getSlotNumberFromRegNo = new GetSlotNumberFromRegNo();

	public static final Map<String, ICommand> commandsMap = new HashMap<String, ICommand>() {
		{
			put(Constants.CREATE_PARKING_LOT, createParkingLot);
			put(Constants.PARK, parkVechicle);
			put(Constants.LEAVE, unparkVehicle);
			put(Constants.STATUS, status);
			put(Constants.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR, getRegistrationNumbersFromColor);
			put(Constants.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR, getSlotNumbersFromColor);
			put(Constants.SLOT_NUMBER_FOR_REGISTRATION_NUMBER, getSlotNumberFromRegNo);
		}
	};

}
