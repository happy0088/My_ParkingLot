package com.go_jek.parking_lot.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.go_jek.parking_lot.command.CommandController;
import com.go_jek.parking_lot.exception.InvalidInputException;

public class FileInputParser {
	CommandRepository commands;
	CommandController controller = new CommandController();

	public FileInputParser() {
		commands = new CommandRepository();
	}

	public void parseFileInput(String filePath) throws InvalidInputException {
		// Assuming input to be a valid file path.
		File inputFile = new File(filePath);
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile));) {
			String line;
			while ((line = br.readLine()) != null) {
				new TextInputParser().parseTextInput(line.trim());
			}
		} catch (Exception ex) {
			Printer.printMessage(Constants.ERROR_READING_FILE, true);
			throw new InvalidInputException(Constants.ERROR_READING_FILE);
		}
	}
}