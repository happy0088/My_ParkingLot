package com.go_jek.parking_lot;

import org.junit.Test;

import com.go_jek.parking_lot.utils.InputParser;
import com.go_jek.parking_lot.utils.Printer;

public class InputParserTest {

	InputParser parser = new InputParser();

	@Test
	public void checkTextInputType() {
		Printer.printMessage("checkTextInputType test", true);
		parser.parseFileInput("file_inputs.txt");
		String[] args = { "file_input.txt" };
		MainDriver.main(args);
	}

}
