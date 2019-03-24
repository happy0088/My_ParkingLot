package com.go_jek.parking_lot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.utils.Constants;

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
		String regNumber="KA 1234";
		String color="Orange";
		service.createParkingLot("10");
		String outputMessage = service.park(regNumber, color);
		assertEquals(regNumber, outputMessage);
	}

}
