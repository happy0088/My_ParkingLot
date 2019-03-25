package com.go_jek.parking_lot.entity;

import com.go_jek.parking_lot.utils.Constants;

public class ParkingLot {

	public Level[] levels;
	private final int numLevels = Constants.DEFAULT_LEVEL_COUNT;
	private static ParkingLot parkingLot = null;

	public Level[] getLevels() {
		return levels;
	}

	public void setLevels(Level[] levels) {
		this.levels = levels;
	}

	public static ParkingLot getParkingLot() {
		return parkingLot;
	}

	public static void setParkingLot(ParkingLot parkingLot) {
		ParkingLot.parkingLot = parkingLot;
	}

	public int getNUM_LEVELS() {
		return numLevels;
	}

	private ParkingLot() {
		levels = new Level[numLevels];
		for (int i = 0; i < numLevels; i++) {
			levels[i] = new Level(i, Constants.DEFAULT_SPOT_COUNT_PER_LEVEL);
		}

	}

	public static ParkingLot getInstance() {
		if (parkingLot == null)
			parkingLot = new ParkingLot();

		return parkingLot;
	}

}
