package main.com.gojek.parking_lot.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import main.com.gojek.parking_lot.command.CommandController;

public class InputParser {
	CommandRepository commands;
	CommandController controller = new CommandController();

	public InputParser() {
		commands = new CommandRepository();
	}

	public void parseTextInput(String inputString) {
		// Split the input string to get command and input value
		String[] inputs = inputString.split(" ");
		controller.setCommand(commands.commandsMap.get(inputs[0]));
		controller.fireCommand(inputs);
	}

	public void parseFileInput(String filePath) {
		// Assuming input to be a valid file path.
		File inputFile = new File(filePath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line;
			try {
				while ((line = br.readLine()) != null) {
					parseTextInput(line.trim());
				}
			} catch (IOException ex) {
				Printer.printMessage("Error in reading the input file.",true);
				ex.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			Printer.printMessage("File not found in the path specified.",true);
			e.printStackTrace();
		}
	}
}