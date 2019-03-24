package com.go_jek.Parking_Lot.parking_lot.entity;

import com.go_jek.Parking_Lot.parking_lot.utils.Constants.VehicleType;

public class ParkingSpot {

	private Vehicle vehicle;
	private VehicleType spotSize;
	private int spotNumber;
	private Level level;
	private boolean isFree = false;

	public ParkingSpot(Level lvl, int num, VehicleType size) {
		level = lvl;
		spotNumber = num;
		spotSize = size;
		isFree = false;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public VehicleType getSpotSize() {
		return spotSize;
	}

	public void setSpotSize(VehicleType spotSize) {
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
