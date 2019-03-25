package com.go_jek.parking_lot.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.go_jek.parking_lot.service.ParkingService;
import com.go_jek.parking_lot.utils.Constants;
import com.go_jek.parking_lot.utils.Printer;

public class Status implements ICommand {

	ParkingService service = new ParkingService();

	@Override
	public String execute(String[] args) {
		String outPutMessage = "";
		if (ParkingService.availableSlots == null) {
			Printer.printMessage(Constants.PARKING_LOT_UNAVAILABLE, true);
			return new ArrayList<>().toString();
		}
		if (ParkingService.registrationSlotMap.isEmpty()) {
			outPutMessage = Constants.PARKING_EMPTY;
			Printer.printMessage(outPutMessage, true);
			return new ArrayList<>().toString();
		} else {

			Set<Entry<String, Integer>> set = ParkingService.registrationSlotMap.entrySet();
			List<Entry<String, Integer>> list = new ArrayList<>(set);
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					return (o1.getValue()).compareTo(o2.getValue());
				}
			});

			outPutMessage = String.format(Constants.HEADER_STRING_FORMAT, Constants.HEADER_SLOT_NO,
					Constants.HEADER_REGISTRATION_NO, Constants.HEADER_COLOR);
			Printer.printMessage(outPutMessage, true);
			for (Entry<String, Integer> entry : list) {
				outPutMessage = String.format(Constants.DATA_STRING_FORMAT, entry.getValue().toString(), entry.getKey(),
						ParkingService.registrationColorMap.get(entry.getKey()));
				Printer.printMessage(outPutMessage, true);

			}
			return list.toString();
		}

	}

}
