package com.go_jek.parking_lot;

import java.io.IOException;

import org.junit.Test;

import com.go_jek.parking_lot.utils.Constants;
import com.go_jek.parking_lot.utils.InputParser;
import com.go_jek.parking_lot.utils.Printer;

public class InputParserTest {

	InputParser parser = new InputParser();

	@Test
	public void checkTextInputType() {
		Printer.printMessage("checkTextInputType test", true);
		try {
			parser.parseFileInput("file_inputs.txt");
		} catch (IOException e) {
			Printer.printMessage(Constants.ERROR_READING_FILE, true);
		}
		String args[] = {"file_input.txt"};
		MainDriver.main(args);
	}

}
