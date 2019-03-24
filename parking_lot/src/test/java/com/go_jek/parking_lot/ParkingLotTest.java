package com.go_jek.parking_lot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;

import com.go_jek.parking_lot.entity.Vehicle;
import com.go_jek.parking_lot.entity.VehicleFactory;
import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.utils.Constants;
import com.go_jek.parking_lot.utils.Constants.VehicleType;

public class ParkingLotTest {

	ParkingService parkingService = new ParkingService();
	String registrationNumber1 = "ABC-123-345";
	String color1 = "White";
	Vehicle vehicle1 = new VehicleFactory().getVehicle(VehicleType.CAR, registrationNumber1, color1);
	String registrationNumber2 = "DEF-123-345";
	String color2 = "Black";
	Vehicle vehicle2 = new VehicleFactory().getVehicle(VehicleType.MOTORCYCLE, registrationNumber2, color2);

	@Test
	public void testSingletonBehavior() {
		int oldLot, newLot;
		parkingService.createParkingLot("6");
		parkingService.park(registrationNumber1, color1);
		oldLot = parkingService.getAvailableSlotCount();
		newLot = parkingService.getAvailableSlotCount();
		assertEquals(oldLot, newLot);
	}

	@Test
	public void shouldAllocateSpace() {
		parkingService.createParkingLot("10");
		assertEquals(parkingService.getAvailableSlotCount(), 10);
	}

	@Test
	public void shouldParkVechicle() {
		parkingService.createParkingLot("10");
		parkingService.park(registrationNumber1, color1);
		assertEquals(parkingService.getAvailableSlotCount(), 9);
		String returnRegNumber = parkingService.getRegistrationNumbersFromColor(color1);
		assertEquals(returnRegNumber.contains(registrationNumber1), true);

	}

	@Test
	public void shouldErrorWhenFull() {
		parkingService.createParkingLot("10");
		parkingService.park(registrationNumber1, color1);
		parkingService.park(registrationNumber2, color2);
		parkingService.park("ABC-12-12-13", "White");
		parkingService.park("ABC-12-12-14", "White");
		parkingService.park("ABC-12-12-15", "White");
		parkingService.park("ABC-12-12-16", "White");
		parkingService.park("ABC-12-12-17", "White");
		parkingService.park("ABC-12-12-18", "White");
		parkingService.park("ABC-12-12-19", "White");
		parkingService.park("ABC-12-12-20", "White");
		String message = parkingService.park(registrationNumber1, color1);
		assertEquals(true, message.equals(Constants.PARKING_FULL));

	}

	@Test
	public void shouldFreeSpaceOnLeaving() {
		parkingService.createParkingLot("10");
		parkingService.park(registrationNumber1, color1);
		int spot = parkingService.leave("1");
		assertEquals(parkingService.getAvailableSlotCount(), 10);
		assertEquals(spot, 1);

	}

	@Test
	public void shouldNotFreeWrongSpaceOnLeaving() {
		parkingService.createParkingLot("10");
		parkingService.park(registrationNumber1, color1);
		int spot = parkingService.leave("1");
		assertEquals(parkingService.getAvailableSlotCount(), 10);
		assertNotEquals(spot, 2);

	}

	@Test
	public void shouldDisplayAllTheVehicles() {
		parkingService.vacateParkingLot();
		parkingService.createParkingLot("10");
		parkingService.park(registrationNumber1, color1);
		parkingService.park(registrationNumber2, color2);
		List result = parkingService.status();
		assertEquals(result.get(0).toString().contains(vehicle1.getRegistrationNumber()), true);
		assertEquals(result.get(1).toString().contains(vehicle2.getRegistrationNumber()), true);

	}

	@Test
	public void shouldReturnRegistrationForAColor() {
		parkingService.createParkingLot("10");
		vehicle2.setColor(color1);
		parkingService.park(registrationNumber2, color1);
		parkingService.park(registrationNumber1, color1);
		String returnRegNumber = parkingService.getRegistrationNumbersFromColor(color1);
		assertEquals(returnRegNumber.contains(registrationNumber1), true);
		assertEquals(returnRegNumber.contains(registrationNumber2), true);
	}

	@Test
	public void shouldReturnSlotForARegistrationNumber() {
		parkingService.createParkingLot("2");
		parkingService.park(registrationNumber1, color1);
		parkingService.park(registrationNumber2, color2);
		int returnSlotNumber = parkingService.getSlotNumberFromRegNo(registrationNumber1);
		assertEquals(returnSlotNumber, 1);
	}

	@Test
	public void shouldNotReturnIncorrectSlotForARegistrationNumber() {
		parkingService.createParkingLot("2");
		parkingService.park(registrationNumber1, color1);
		parkingService.park(registrationNumber2, color2);
		int returnSlotNumber = parkingService.getSlotNumberFromRegNo(registrationNumber1);
		assertNotEquals(returnSlotNumber, 2);
	}

	@Test
	public void shouldReturnSlotNumberForAColor() {
		parkingService.createParkingLot("2");
		parkingService.park(registrationNumber1, color1);
		parkingService.park(registrationNumber2, color2);
		String returnSlotNumber = parkingService.getSlotNumbersFromColor(color1);
		assertEquals(returnSlotNumber.contains("1"), true);
	}

}
