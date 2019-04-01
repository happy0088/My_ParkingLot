package com.gojek.parking_lot.entity;

import com.gojek.parking_lot.utils.Constants.ParkingSpotType;
import com.gojek.parking_lot.utils.Constants.VehicleType;

public class ParkingSpot {

	private Vehicle vehicle;
	private ParkingSpotType spotSize;
	private int spotNumber;
	private Level level;
	private boolean isFree = true;

	public ParkingSpot(Level lvl, int num, ParkingSpotType size) {
		level = lvl;
		spotNumber = num;
		spotSize = size;
		isFree = true;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSpotType getSpotSize() {
		return spotSize;
	}

	public void setSpotSize(ParkingSpotType spotSize) {
		this.spotSize = spotSize;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(int spotNumber) {
		this.spotNumber = spotNumber;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setIsFree(boolean status) {
		isFree = status;
	}

}
