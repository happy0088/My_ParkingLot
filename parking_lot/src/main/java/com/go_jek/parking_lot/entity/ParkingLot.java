package com.go_jek.parking_lot.entity;

import com.go_jek.parking_lot.utils.Constants;

public class ParkingLot {

	public Level[] levels;
	private static int numLevels = Constants.DEFAULT_LEVEL_COUNT;
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

	}

	private ParkingLot(int noOflevels, int spotsPerLevel) {
		numLevels = noOflevels;
		levels = new Level[noOflevels];
		for (int i = 0; i < noOflevels; i++) {
			levels[i] = new Level(i, spotsPerLevel);
		}

	}

	public static ParkingLot getInstance(int noOfLevels, int noOfslots) {
		if (parkingLot == null)
			parkingLot = new ParkingLot(noOfLevels, noOfslots);

		return parkingLot;
	}

}
