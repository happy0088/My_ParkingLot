package com.go_jek.parking_lot.entity;

public class ParkingLot {

	public Level[] levels;
	private final int NUM_LEVELS = 5;
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
		return NUM_LEVELS;
	}

	private ParkingLot() {
		levels = new Level[NUM_LEVELS];
		for (int i = 0; i < NUM_LEVELS; i++) {
			levels[i] = new Level(i, 30);
		}

	}

	public static ParkingLot getInstance() {
		if (parkingLot == null)
			parkingLot = new ParkingLot();

		return parkingLot;
	}

}
