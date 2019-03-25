package com.go_jek.parking_lot.service;

import com.go_jek.parking_lot.entity.Vehicle;
import com.go_jek.parking_lot.utils.Printer;

public class TicketService {

	public static void issueTicket(Vehicle vehicle) {
		Printer.printTicket(vehicle);
	}

}
