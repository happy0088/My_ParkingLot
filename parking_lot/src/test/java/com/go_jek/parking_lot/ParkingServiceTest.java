package com.go_jek.parking_lot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.utils.Constants;
import com.go_jek.parking_lot.utils.Constants.VehicleType;

public class ParkingServiceTest {

	ParkingService service = new ParkingService();

	@Test
	public void checkCreateParkingLot() {
		String size = "10";
		String expected = Constants.CREATED_PARKING_LOT_WITH + size + Constants.SLOTS;
		String outputMessage = service.createParkingLot(size);
		assertEquals(expected, outputMessage);
	}

	@Test
	public void checkPark() {
		String regNumber = "KA 1234";
		String color = "Orange";
		service.createParkingLot("10");
		String outputMessage = service.park(regNumber, color, VehicleType.CAR);
		assertEquals(regNumber, outputMessage);
	}

	@Test
	public void checkGetRegistrationNumbersFromColor() {
		String regNumber = "KA 12347";
		String color = "Amber";
		service.createParkingLot("10");
		 service.park(regNumber, color, VehicleType.CAR);
		String outputMessage = service.getRegistrationNumbersFromColor(color);
		assertEquals(regNumber, outputMessage);
	}
	
	@Test
	public void checkGetSlotNumbersFromColors() {
		String regNumber = "KA 1234";
		String color = "Red";
		service.createParkingLot("10");
		 service.park(regNumber, color, VehicleType.CAR);
		String outputMessage = service.getSlotNumbersFromColor(color);
		assertEquals("1", outputMessage);
	}
	
	@Test
	public void checkGetSlotNumberFromRegNo() {
		String regNumber = "KA 123456";
		String color = "Red";
		service.createParkingLot("10");
		 service.park(regNumber, color, VehicleType.CAR);
		int outputMessage = service.getSlotNumberFromRegNo(regNumber);
		assertEquals(1, outputMessage);
	}
	
	@Test
	public void checkLeave() {
		String regNumber = "KA 123456";
		String color = "Voilet";
		service.createParkingLot("10");
		 service.park(regNumber, color, VehicleType.CAR);
		int outputMessage = service.leave("1");
		assertEquals(1, outputMessage);
	}
	
}
