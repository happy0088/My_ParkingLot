package com.gojek.parking_lot.utils;

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
	public static final VehicleType DEFAULT_VEHICLE = VehicleType.CAR;
	public static final ParkingSpotType DEFAULT_PARKINGSPOT_TYPE = ParkingSpotType.SMALL;
	public static final int DEFAULT_LEVEL_COUNT = 5;
	public static final int DEFAULT_SPOT_COUNT_PER_LEVEL = 30;
	public static final String ERROR_READING_CONSOLE = "Error in reading the input from console.";
	public static final String INVALID_INPUT_WITH_USAGE = "Invalid input !!! Usage: java -jar <jar_file_path> <input_file_path>";
	public static final String EXIT = "exit";
	public static final String INPUT_ERROR = "Invalid Input, Please verify.";
	public static final String HEADER_STRING_FORMAT = "%-10s  %10s    %s";
	public static final String DATA_STRING_FORMAT = "%-10s  %10s      %s ";
	public static final String ALLOCATED_SLOT_NUMBER = "Allocated slot number: ";
	public static final String PARKING_FULL = "Sorry, parking lot is full";
	public static final String ERROR_READING_FILE = "Error in reading the input file.";
	public static final String FILE_NOT_FOUND = "File not found in the path specified.";
	public static final String INPUT_STRING_DELIMETER = " ";
	public static final String PARKING_EMPTY = "Parking is empty";
	public static final String HEADER_SLOT_NO = "Slot No.";
	public static final String HEADER_REGISTRATION_NO = "Registration No";
	public static final String HEADER_COLOR = "Colour";
	public static final String CREATED_PARKING_LOT_WITH = "Created a parking lot with ";
	public static final String SLOTS = " slots";
	public static final String VACATE = "vacate";

	public enum VehicleType {
		CAR, TRUCK, ELECTRIC, VAN, MOTORCYCLE
	}

	public enum ParkingSpotType {
		HANDICAPPED, COMPACT, SMALL, LARGE, MOTORCYCLE, ELECTRIC
	}
}
