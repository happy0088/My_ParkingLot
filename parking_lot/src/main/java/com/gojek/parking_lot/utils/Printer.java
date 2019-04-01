package com.gojek.parking_lot.utils;

/*import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;*/

import com.gojek.parking_lot.entity.Vehicle;

public class Printer {

	private Printer() {
	}

	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s");
	}
	static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Printer.class.getName());

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
