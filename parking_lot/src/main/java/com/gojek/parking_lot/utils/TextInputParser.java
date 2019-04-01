package com.gojek.parking_lot.utils;

import com.gojek.parking_lot.command.CommandController;

public class TextInputParser {
	CommandRepository commands;
	CommandController controller = new CommandController();

	public TextInputParser() {
		commands = new CommandRepository();
	}

	public String parseTextInput(String inputString) {
		// Split the input string to get command and input value
		String[] inputs = inputString.split(Constants.INPUT_STRING_DELIMETER);
		try {
			controller.setCommand(CommandRepository.commandsMap.get(inputs[0]));
			return controller.fireCommand(inputs);
		} catch (Exception e) {
			Printer.printMessage(Constants.INPUT_ERROR, true);
			return Constants.INPUT_ERROR;
		}
		
	}

}