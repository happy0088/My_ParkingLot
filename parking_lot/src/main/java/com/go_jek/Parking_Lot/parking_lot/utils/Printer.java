package com.go_jek.Parking_Lot.parking_lot.utils;

import org.apache.log4j.Logger;

public class Printer {
	static Logger logger = Logger.getLogger(Printer.class);

	public static void printMessage(String message, boolean hasNewLine) {
		String outputMessage = message;
		if (hasNewLine)
			outputMessage = outputMessage.concat(Constants.NEW_LINE);
		logger.info(outputMessage);
	}

}
