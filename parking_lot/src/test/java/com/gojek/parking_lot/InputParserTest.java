package com.gojek.parking_lot;

import org.junit.Test;

import com.gojek.parking_lot.MainDriver;
import com.gojek.parking_lot.exception.InvalidInputException;
import com.gojek.parking_lot.utils.Constants;
import com.gojek.parking_lot.utils.FileInputParser;
import com.gojek.parking_lot.utils.Printer;

public class InputParserTest {

	FileInputParser parser = new FileInputParser();

	@Test
	public void checkTextInputType() {
		Printer.printMessage("checkTextInputType test", true);
		try {
			parser.parseFileInput("file_inputs.txt");
		} catch (InvalidInputException e) {
			Printer.printMessage(Constants.ERROR_READING_FILE, true);
		}
		String[] args = { "file_input.txt" };
		MainDriver.main(args);
	}

}
