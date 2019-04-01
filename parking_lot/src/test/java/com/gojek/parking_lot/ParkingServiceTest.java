package com.gojek.parking_lot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gojek.parking_lot.command.CreateParkingLot;
import com.gojek.parking_lot.command.GetRegistrationNumbersFromColor;
import com.gojek.parking_lot.command.GetSlotNumberFromRegNo;
import com.gojek.parking_lot.command.GetSlotNumbersFromColor;
import com.gojek.parking_lot.command.ParkVehicle;
import com.gojek.parking_lot.command.Status;
import com.gojek.parking_lot.command.UnParkVehicle;
import com.gojek.parking_lot.exception.InvalidInputException;
import com.gojek.parking_lot.service.ParkingService;
import com.gojek.parking_lot.utils.Constants;
import com.gojek.parking_lot.utils.Constants.VehicleType;

public class ParkingServiceTest {

	ParkingService service = new ParkingService();
	CreateParkingLot createparkingLot = new CreateParkingLot();
	ParkVehicle parkVehicle = new ParkVehicle();
	GetRegistrationNumbersFromColor getRegistrationNumbersFromColor = new GetRegistrationNumbersFromColor();
	UnParkVehicle unparkVehicle = new UnParkVehicle();
	Status status = new Status();
	GetSlotNumberFromRegNo getSlotNumberFromRegNo = new GetSlotNumberFromRegNo();
	GetSlotNumbersFromColor getSlotNumbersFromColor = new GetSlotNumbersFromColor();

	@Test
	public void checkCreateParkingLot() throws InvalidInputException {
		String size = "10";
		String expected = Constants.CREATED_PARKING_LOT_WITH + size + Constants.SLOTS;
		String outputMessage = createparkingLot.execute(new String[] {"", size });
		assertEquals(expected, outputMessage);
	}

	@Test
	public void checkPark() throws InvalidInputException {
		String regNumber = "KA 1234";
		String color = "Orange";
		createparkingLot.execute(new String[] {"", "10" });
		String outputMessage = parkVehicle.execute(new String[] {"", regNumber, color, VehicleType.CAR.name() });
		assertEquals(regNumber, outputMessage);
	}

	@Test
	public void checkGetRegistrationNumbersFromColor() throws InvalidInputException {
		String regNumber = "KA 12347";
		String color = "Amber";
		createparkingLot.execute(new String[] {"", "10" });
		parkVehicle.execute(new String[] {"", regNumber, color, VehicleType.CAR.name() });
		String outputMessage = getRegistrationNumbersFromColor.execute(new String[] {"", color });
		assertEquals(regNumber, outputMessage);
	}

	@Test
	public void checkGetSlotNumbersFromColors() throws InvalidInputException {
		String regNumber = "KA 1234";
		String color = "Red";
		createparkingLot.execute(new String[] {"", "10" });
		parkVehicle.execute(new String[] {"", regNumber, color, VehicleType.CAR.name() });
		String outputMessage = getSlotNumbersFromColor.execute(new String[] {"", color });
		assertEquals("1", outputMessage);
	}

	@Test
	public void checkGetSlotNumberFromRegNo() throws InvalidInputException {
		String regNumber = "KA 123456";
		String color = "Red";
		createparkingLot.execute(new String[] {"", "10" });
		parkVehicle.execute(new String[] {"", regNumber, color, VehicleType.CAR.name() });
		String outputMessage = getSlotNumberFromRegNo.execute(new String[] {"", regNumber });
		assertEquals("1", outputMessage);
	}

	@Test
	public void checkLeave() throws InvalidInputException {
		String regNumber = "KA 123456";
		String color = "Voilet";
		createparkingLot.execute(new String[] {"", "10" });
		parkVehicle.execute(new String[] {"", regNumber, color, VehicleType.CAR.name() });
		String outputMessage = unparkVehicle.execute(new String[] {"", "1" });
		assertEquals("1", outputMessage);
	}

}
