package com.go_jek.parking_lot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.go_jek.parking_lot.command.CreateParkingLot;
import com.go_jek.parking_lot.command.GetRegistrationNumbersFromColor;
import com.go_jek.parking_lot.command.GetSlotNumberFromRegNo;
import com.go_jek.parking_lot.command.GetSlotNumbersFromColor;
import com.go_jek.parking_lot.command.ParkVehicle;
import com.go_jek.parking_lot.command.Status;
import com.go_jek.parking_lot.command.UnParkVehicle;
import com.go_jek.parking_lot.entity.Vehicle;
import com.go_jek.parking_lot.entity.VehicleFactory;
import com.go_jek.parking_lot.exception.InvalidInputException;
import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.utils.Constants;
import com.go_jek.parking_lot.utils.Constants.VehicleType;

public class ParkingLotTest {

	ParkingService parkingService = new ParkingService();
	String registrationNumber1 = "ABC-123-345";
	static final String COLOR_WHITE = "White";
	Vehicle vehicle1 = new VehicleFactory().getVehicle(VehicleType.CAR, registrationNumber1, COLOR_WHITE);
	String registrationNumber2 = "DEF-123-345";
	String color2 = "Black";
	Vehicle vehicle2 = new VehicleFactory().getVehicle(VehicleType.MOTORCYCLE, registrationNumber2, color2);
	CreateParkingLot createparkingLot = new CreateParkingLot();
	ParkVehicle parkVehicle = new ParkVehicle();
	GetRegistrationNumbersFromColor getRegistrationNumbersFromColor = new GetRegistrationNumbersFromColor();
	UnParkVehicle unparkVehicle = new UnParkVehicle();
	Status status = new Status();
	GetSlotNumberFromRegNo getSlotNumberFromRegNo = new GetSlotNumberFromRegNo();
	GetSlotNumbersFromColor getSlotNumbersFromColor = new GetSlotNumbersFromColor();

	@Test
	public void testSingletonBehavior() throws InvalidInputException {
		int oldLot, newLot;
		createparkingLot.execute(new String[] {"", "6" });
		parkVehicle.execute(new String[] {"", registrationNumber1, COLOR_WHITE, VehicleType.CAR.name() });
		oldLot = parkingService.getAvailableSlotCount();
		newLot = parkingService.getAvailableSlotCount();
		assertEquals(oldLot, newLot);
	}

	@Test
	public void shouldAllocateSpace() throws InvalidInputException {
		createparkingLot.execute(new String[] {"", "10" });
		assertEquals(parkingService.getAvailableSlotCount(), 10);
	}

	@Test
	public void shouldParkVechicle() throws InvalidInputException {
		createparkingLot.execute(new String[] {"", "10" });
		parkVehicle.execute(new String[] {"", registrationNumber1, COLOR_WHITE, VehicleType.CAR.name() });
		assertEquals(parkingService.getAvailableSlotCount(), 9);
		String returnRegNumber = getRegistrationNumbersFromColor.execute(new String[] {"", COLOR_WHITE });
		assertEquals(returnRegNumber.contains(registrationNumber1), true);

	}

	@Test
	public void shouldErrorWhenFull() throws InvalidInputException {
		createparkingLot.execute(new String[] {"", "10" });
		parkVehicle.execute(new String[] {"", registrationNumber1, COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", registrationNumber2, color2, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", "ABC-12-12-13", COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", "ABC-12-12-14", COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", "ABC-12-12-15", COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", "ABC-12-12-16", COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", "ABC-12-12-17", COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", "ABC-12-12-18", COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", "ABC-12-12-19", COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", "ABC-12-12-20", COLOR_WHITE, VehicleType.CAR.name() });
		String message = parkVehicle.execute(new String[] {"", registrationNumber1, COLOR_WHITE, VehicleType.CAR.name() });
		assertEquals(true, message.equals(Constants.PARKING_FULL));

	}

	@Test
	public void shouldFreeSpaceOnLeaving() throws InvalidInputException {
		createparkingLot.execute(new String[] {"", "10" });
		parkVehicle.execute(new String[] {"", registrationNumber1, COLOR_WHITE, VehicleType.CAR.name() });
		String spot = unparkVehicle.execute(new String[] {"", "1" });
		assertEquals(parkingService.getAvailableSlotCount(), 10);
		assertEquals(spot, "1");

	}

	@Test
	public void shouldNotFreeWrongSpaceOnLeaving() throws InvalidInputException {
		createparkingLot.execute(new String[] {"", "10" });
		parkVehicle.execute(new String[] {"", registrationNumber1, COLOR_WHITE, VehicleType.CAR.name() });
		String spot = unparkVehicle.execute(new String[] {"", "1" });
		assertEquals(parkingService.getAvailableSlotCount(), 10);
		assertNotEquals(spot, "2");

	}

	@Test
	public void shouldDisplayAllTheVehicles() throws InvalidInputException {
		parkingService.vacateParkingLot();
		createparkingLot.execute(new String[] {"", "10" });
		parkVehicle.execute(new String[] {"", registrationNumber1, COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", registrationNumber2, color2, VehicleType.CAR.name() });
		String result = status.execute(new String[] {"",});
		assertEquals(result.contains(vehicle1.getRegistrationNumber()), true);
		assertEquals(result.contains(vehicle2.getRegistrationNumber()), true);

	}

	@Test
	public void shouldReturnRegistrationForAColor() throws InvalidInputException {
		createparkingLot.execute(new String[] {"", "10" });
		vehicle2.setColor(COLOR_WHITE);
		parkVehicle.execute(new String[] {"", registrationNumber2, COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", registrationNumber1, COLOR_WHITE, VehicleType.CAR.name() });
		String returnRegNumber = getRegistrationNumbersFromColor.execute(new String[] {"", COLOR_WHITE });
		assertEquals(returnRegNumber.contains(registrationNumber1), true);
		assertEquals(returnRegNumber.contains(registrationNumber2), true);
	}

	@Test
	public void shouldReturnSlotForARegistrationNumber() throws InvalidInputException {
		createparkingLot.execute(new String[] {"", "2" });
		parkVehicle.execute(new String[] {"", registrationNumber1, COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", registrationNumber2, color2, VehicleType.CAR.name() });
		String returnSlotNumber = getSlotNumberFromRegNo.execute(new String[] {"", registrationNumber1 });
		assertEquals(returnSlotNumber, "1");
	}

	@Test
	public void shouldNotReturnIncorrectSlotForARegistrationNumber() throws InvalidInputException {
		createparkingLot.execute(new String[] {"", "2" });
		parkVehicle.execute(new String[] {"", registrationNumber1, COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", registrationNumber2, color2, VehicleType.CAR.name() });
		String returnSlotNumber = getSlotNumberFromRegNo.execute(new String[] {"", registrationNumber1 });
		assertNotEquals(returnSlotNumber, "2");
	}

	@Test
	public void shouldReturnSlotNumberForAColor() throws InvalidInputException {
		createparkingLot.execute(new String[] {"", "2" });
		parkVehicle.execute(new String[] {"", registrationNumber1, COLOR_WHITE, VehicleType.CAR.name() });
		parkVehicle.execute(new String[] {"", registrationNumber2, color2, VehicleType.CAR.name() });
		String returnSlotNumber = getSlotNumbersFromColor.execute(new String[] {"", COLOR_WHITE });
		assertEquals(returnSlotNumber.contains("1"), true);
	}

}
