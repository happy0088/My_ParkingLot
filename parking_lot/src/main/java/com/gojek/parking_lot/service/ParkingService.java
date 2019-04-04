package com.gojek.parking_lot.service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import com.gojek.parking_lot.entity.ParkingLot;

public class ParkingService {

	public static Map<String, Integer> registrationSlotMap = new HashMap<>();
	public static Map<String, String> registrationColorMap = new HashMap<>();
	public static TreeSet<Integer> availableSlots = null;
	public static ParkingLot parkingLot;

	public int getAvailableSlotCount() {
		return availableSlots.size();
	}

	public static int allocateFreeSlots(int noOfslots, int noOfLevels) {

		ParkingLot parkingLotTemp = ParkingLot.getInstance(noOfLevels, noOfslots);
		if (null == parkingLot || !parkingLot.equals(parkingLotTemp)) {
			parkingLot = parkingLotTemp;
			availableSlots = new TreeSet<>();
			for (int i = 1; i <= noOfslots; i++) {
				availableSlots.add(i);
			}
		}
		return availableSlots.size();
	}

}
