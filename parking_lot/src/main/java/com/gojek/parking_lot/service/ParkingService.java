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

	public static void allocateFreeSlots(int noOfslots, int noOfLevels) {
		parkingLot = ParkingLot.getInstance(noOfLevels, noOfslots);
		availableSlots = new TreeSet<>();
		for (int i = 1; i <= noOfslots; i++) {
			availableSlots.add(i);
		}
	}

}
