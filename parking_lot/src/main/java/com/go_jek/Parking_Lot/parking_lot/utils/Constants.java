package com.go_jek.Parking_Lot.parking_lot.utils;

public class Constants {

	public static final String CREATE_PARKING_LOT = "create_parking_lot";
	public static final String PARK = "park";
	public static final String LEAVE = "leave";
	public static final String STATUS = "status";
	public static final String REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR = "registration_numbers_for_cars_with_colour";
	public static final String SLOT_NUMBERS_FOR_CARS_WITH_COLOUR = "slot_numbers_for_cars_with_colour";
	public static final String SLOT_NUMBER_FOR_REGISTRATION_NUMBER = "slot_number_for_registration_number";
	public static final String CAR = "Car";
	public static final String PARKING_LOT_UNAVAILABLE = "Error! , Please Create ParkingLot First";
	public static final String NEW_LINE = "\n";
	public static final String EMPTY_STRING = "";
	public static final String NOT_FOUND = "Not found";
	public static final String ERROR_READING_CONSOLE = "Error in reading the input from console.";
	public static final String INVALID_INPUT_WITH_USAGE = "Invalid input !!! Usage: java -jar <jar_file_path> <input_file_path>";
	public static final String EXIT = "exit";
	public static final String HEADER_STRING_FORMAT = "%-10s  %10s    %s";
	public static final String DATA_STRING_FORMAT = "%-10s  %10s      %s ";
	public static final String ALLOCATED_SLOT_NUMBER = "Allocated slot number: ";
	public static final String PARKING_FULL = "Sorry, parking lot is full";

	public enum VehicleType {
		CAR, TRUCK, ELECTRIC, VAN, MOTORCYCLE
	}

	public enum ParkingSpotType {
		HANDICAPPED, COMPACT, SMALL, LARGE, MOTORCYCLE, ELECTRIC
	}
}
