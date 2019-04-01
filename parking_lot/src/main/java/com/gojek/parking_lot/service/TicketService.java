package com.gojek.parking_lot.service;

import com.gojek.parking_lot.entity.Vehicle;
import com.gojek.parking_lot.utils.Printer;

public class TicketService {

	public static void issueTicket(Vehicle vehicle) {
		Printer.printTicket(vehicle);
	}

}
