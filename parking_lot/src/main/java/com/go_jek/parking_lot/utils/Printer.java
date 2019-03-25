package com.go_jek.parking_lot.utils;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.go_jek.parking_lot.entity.Vehicle;

public class Printer {

	private Printer() {
		BasicConfigurator.configure();
	}

	static Logger logger = Logger.getLogger(Printer.class);

	public static void printMessage(String message, boolean hasNewLine) {
		String outputMessage = message;
		if (hasNewLine)
			outputMessage = outputMessage.concat(Constants.NEW_LINE);
		logger.info(outputMessage);
	}

	public static void printTicket(Vehicle vehicle) {
		/* calls for priniting ticket to the driver . */
		String message = "Printing ticket for the Vehicle" + vehicle;
	}

}
