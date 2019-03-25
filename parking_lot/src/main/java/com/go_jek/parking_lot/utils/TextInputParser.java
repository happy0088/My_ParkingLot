package com.go_jek.parking_lot.utils;

import com.go_jek.parking_lot.command.CommandController;
import com.go_jek.parking_lot.exception.InvalidInputException;

public class TextInputParser {
	CommandRepository commands;
	CommandController controller = new CommandController();

	public TextInputParser() {
		commands = new CommandRepository();
	}

	public void parseTextInput(String inputString) {
		// Split the input string to get command and input value
		String[] inputs = inputString.split(Constants.INPUT_STRING_DELIMETER);
		controller.setCommand(CommandRepository.commandsMap.get(inputs[0]));
		try {
			controller.fireCommand(inputs);
		} catch (InvalidInputException e) {
			Printer.printMessage(Constants.INPUT_ERROR, true);
		}
	}

}