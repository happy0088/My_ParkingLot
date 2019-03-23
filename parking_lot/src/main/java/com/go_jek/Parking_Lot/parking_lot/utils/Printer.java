package com.go_jek.Parking_Lot.parking_lot.utils;

public class Printer {
	// static Logger logger = Logger.getLogger(Printer.class);
	public static void printMessage(String message, boolean hasNewLine) {
		// logger.info("Logging here");
		String outputMessage = message;
		if (hasNewLine)
			outputMessage = outputMessage.concat(Constants.NEW_LINE);
		System.out.print(outputMessage);
	}

}
