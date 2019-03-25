package com.go_jek.parking_lot.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.go_jek.parking_lot.command.CommandController;

public class InputParser {
	CommandRepository commands;
	CommandController controller = new CommandController();

	public InputParser() {
		commands = new CommandRepository();
	}

	public void parseTextInput(String inputString) {
		// Split the input string to get command and input value
		String[] inputs = inputString.split(Constants.INPUT_STRING_DELIMETER);
		controller.setCommand(CommandRepository.commandsMap.get(inputs[0]));
		controller.fireCommand(inputs);
	}

	public void parseFileInput(String filePath) throws IOException {
		// Assuming input to be a valid file path.
		File inputFile = new File(filePath);
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile));) {
			String line;
			while ((line = br.readLine()) != null) {
				parseTextInput(line.trim());
			}
		} catch (Exception ex) {
			Printer.printMessage(Constants.ERROR_READING_FILE, true);
		}
	}
}