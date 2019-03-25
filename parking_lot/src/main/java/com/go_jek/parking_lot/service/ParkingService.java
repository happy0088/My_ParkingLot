package com.go_jek.parking_lot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.go_jek.parking_lot.entity.ParkingLot;
import com.go_jek.parking_lot.entity.Vehicle;
import com.go_jek.parking_lot.entity.VehicleFactory;
import com.go_jek.parking_lot.utils.Constants;
import com.go_jek.parking_lot.utils.Constants.VehicleType;
import com.go_jek.parking_lot.utils.Printer;

public class ParkingService {

	private static Map<String, Integer> registrationSlotMap = new HashMap<String, Integer>();
	private static Map<String, String> registrationColorMap = new HashMap<String, String>();
	private static TreeSet<Integer> availableSlots = null;
	private static ParkingLot parkingLot;
	private static String outPutMessage = "";

	public boolean parkVehicle(Vehicle vehicle) {
		for (int i = 0; i < parkingLot.levels.length; i++) {
			if (parkingLot.levels[i].parkVehicle(vehicle)) {
				return true;
			}
		}
		return false;
	}

	public boolean unParkVehicle(int spotNumber, String regNumber) {
		for (int i = 0; i < parkingLot.levels.length; i++) {
			if (parkingLot.levels[i].unParkVehicle(spotNumber)) {
				registrationColorMap.remove(regNumber);
				registrationSlotMap.values().remove(spotNumber);
				availableSlots.add(spotNumber);
				return true;
			}
		}
		return false;
	}

	public String vacateParkingLot() {
		availableSlots.clear();
		registrationColorMap.clear();
		registrationSlotMap.clear();
		return null;

	}

	public String createParkingLot(String slotSize) {
		allocateFreeSlots(Integer.parseInt(slotSize), Constants.DEFAULT_LEVEL_COUNT);
		outPutMessage = Constants.CREATED_PARKING_LOT_WITH + slotSize + Constants.SLOTS;
		Printer.printMessage(outPutMessage, true);
		return outPutMessage;
	}

	public int getAvailableSlotCount() {
		return availableSlots.size();
	}

	public String park(String regNumber, String color, VehicleType vehicleType) {
		if (availableSlots == null) {
			outPutMessage = Constants.PARKING_LOT_UNAVAILABLE;
			Printer.printMessage(outPutMessage, true);
			return outPutMessage;
		}
		if (!availableSlots.isEmpty()) {
			Vehicle vehicle = new VehicleFactory().getVehicle(vehicleType, regNumber, color);
			parkVehicle(vehicle);
			int location = availableSlots.first();
			registrationSlotMap.put(vehicle.getRegistrationNumber(), location);
			registrationColorMap.put(vehicle.getRegistrationNumber(), vehicle.getColor());
			outPutMessage = Constants.ALLOCATED_SLOT_NUMBER + location;
			Printer.printMessage(outPutMessage, true);
			availableSlots.remove(location);
			issueTicket(vehicle);
			return vehicle.getRegistrationNumber();
		} else {
			outPutMessage = Constants.PARKING_FULL;
			Printer.printMessage(Constants.PARKING_FULL, true);
		}
		return outPutMessage;
	}

	public int leave(String spot) {
		if (availableSlots == null) {
			Printer.printMessage(Constants.PARKING_LOT_UNAVAILABLE, true);
			return 0;
		}
		for (Entry<String, Integer> entry : registrationSlotMap.entrySet()) {
			int spotNUmber = Integer.parseInt(spot);
			if (entry.getValue() == (Integer.parseInt(spot))) {
				unParkVehicle(spotNUmber, entry.getKey());
				outPutMessage = "Slot number " + spot + " is free";
				Printer.printMessage(outPutMessage, true);
				return spotNUmber;
			}
		}
		return 0;

	}

	public List status() {
		if (availableSlots == null) {
			Printer.printMessage(Constants.PARKING_LOT_UNAVAILABLE, true);
			return new ArrayList<>();
		}
		if (registrationSlotMap.isEmpty()) {
			outPutMessage = Constants.PARKING_EMPTY;
			Printer.printMessage(outPutMessage, true);
			return new ArrayList<>();
		} else {

			Set<Entry<String, Integer>> set = registrationSlotMap.entrySet();
			List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					return (o1.getValue()).compareTo(o2.getValue());
				}
			});

			outPutMessage = String.format(Constants.HEADER_STRING_FORMAT, Constants.HEADER_SLOT_NO,
					Constants.HEADER_REGISTRATION_NO, Constants.HEADER_COLOR);
			Printer.printMessage(outPutMessage, true);
			for (Entry<String, Integer> entry : list) {
				outPutMessage = String.format(Constants.DATA_STRING_FORMAT, entry.getValue().toString(), entry.getKey(),
						registrationColorMap.get(entry.getKey()));
				Printer.printMessage(outPutMessage, true);

			}
			return list;
		}

	}

	public String getRegistrationNumbersFromColor(String color) {
		if (availableSlots == null) {
			outPutMessage = Constants.PARKING_LOT_UNAVAILABLE;
			Printer.printMessage(outPutMessage, true);
			return outPutMessage;
		}
		int count = 1;
		String registrations = Constants.EMPTY_STRING;
		for (Entry<String, String> entry : registrationColorMap.entrySet()) {
			if (entry.getValue().equals(color)) {
				if (count > 1) {
					outPutMessage = ", ";
					Printer.printMessage(outPutMessage, false);
				}
				outPutMessage = entry.getKey();
				Printer.printMessage(outPutMessage, false);
				count++;
				registrations += entry.getKey();
			}
		}
		if (count == 1) {
			Printer.printMessage(Constants.NOT_FOUND, true);
		} else
			Printer.printMessage(Constants.EMPTY_STRING, true);
		return registrations;
	}

	public int getSlotNumberFromRegNo(String registrationNumber) {
		if (availableSlots == null) {
			Printer.printMessage(Constants.PARKING_LOT_UNAVAILABLE, true);
			return 0;
		}
		Integer regNumber = registrationSlotMap.get(registrationNumber);
		if (regNumber == null) {
			Printer.printMessage(Constants.NOT_FOUND, true);
			return 0;
		} else {
			Printer.printMessage(regNumber.toString(), true);
			return regNumber;
		}
	}

	public String getSlotNumbersFromColor(String color) {
		if (availableSlots == null) {
			outPutMessage = Constants.PARKING_LOT_UNAVAILABLE;
			Printer.printMessage(outPutMessage, true);
			return outPutMessage;
		}
		int count = 1;
		String registrationNumbers = Constants.EMPTY_STRING;
		for (Entry<String, String> entry : registrationColorMap.entrySet()) {
			if (entry.getValue().equals(color)) {
				if (count > 1) {
					Printer.printMessage(", ", false);
				}
				Printer.printMessage(registrationSlotMap.get(entry.getKey()).toString(), false);
				registrationNumbers += registrationSlotMap.get(entry.getKey());
				count++;
			}
		}
		if (count == 1) {
			Printer.printMessage(Constants.NOT_FOUND, true);
		} else
			Printer.printMessage(Constants.EMPTY_STRING, true);
		return registrationNumbers;
	}

	public static void allocateFreeSlots(int noOfslots,int noOfLevels) {
		parkingLot = ParkingLot.getInstance(noOfLevels,noOfslots);
		availableSlots = new TreeSet<>();
		for (int i = 1; i <= noOfslots; i++) {
			availableSlots.add(i);
		}
	}

	public void issueTicket(Vehicle vehicle) {
		Printer.printTicket(vehicle);
	}

}
