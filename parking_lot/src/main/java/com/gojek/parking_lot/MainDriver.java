package com.gojek.parking_lot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gojek.parking_lot.exception.InvalidInputException;
import com.gojek.parking_lot.utils.Constants;
import com.gojek.parking_lot.utils.FileInputParser;
import com.gojek.parking_lot.utils.Printer;
import com.gojek.parking_lot.utils.TextInputParser;

public class MainDriver {

	public static void main(String[] args) {

		TextInputParser textInputParser = new TextInputParser();
		FileInputParser fileInputParser = new FileInputParser();
		switch (args.length) {
		case 0:
			while (true) {
				try {
					BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
					String inputString = bufferRead.readLine();
					if (inputString.equalsIgnoreCase(Constants.EXIT)) {
						break;
					} else if ((inputString.isEmpty())) {
						// Do nothing
					} else {
						textInputParser.parseTextInput(inputString.trim());
					}
				} catch (IOException e) {
					Printer.printMessage(Constants.ERROR_READING_CONSOLE, true);
				}
			}
			break;
		case 1:
			try {
				fileInputParser.parseFileInput(args[0]);
			} catch (InvalidInputException e) {
				Printer.printMessage(Constants.ERROR_READING_FILE, true);
			}
			break;
		default:
			Printer.printMessage(Constants.INVALID_INPUT_WITH_USAGE, true);
		}
	}
}
