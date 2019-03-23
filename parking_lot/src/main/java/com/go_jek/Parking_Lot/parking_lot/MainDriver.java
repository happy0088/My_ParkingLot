package main.com.gojek.parking_lot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.com.gojek.parking_lot.utils.Constants;
import main.com.gojek.parking_lot.utils.InputParser;
import main.com.gojek.parking_lot.utils.Printer;

public class MainDriver {

	public static void main(String[] args) {
		
		InputParser inputParser = new InputParser();
		switch (args.length) {
		case 0:
			while (true) {
				try {
					BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
					String inputString = bufferRead.readLine();
					if (inputString.equalsIgnoreCase(Constants.EXIT)) {
						break;
					} else if ((null == inputString) || (inputString.isEmpty())) {
						// Do nothing
					} else {
						inputParser.parseTextInput(inputString.trim());
					}
				} catch (IOException e) {
					Printer.printMessage(Constants.ERROR_READING_CONSOLE, true);
					e.printStackTrace();
				}
			}
			break;
		case 1:
			// File input/output
			inputParser.parseFileInput(args[0]);
			break;
		default:
			Printer.printMessage(Constants.INVALID_INPUT_WITH_USAGE, true);
		}
	}
}
