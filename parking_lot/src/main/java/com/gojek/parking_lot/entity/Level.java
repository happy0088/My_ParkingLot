package com.gojek.parking_lot.entity;

import com.gojek.parking_lot.utils.Constants;
import com.gojek.parking_lot.utils.Constants.ParkingSpotType;

public class Level {

	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0;

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public ParkingSpot[] getSpots() {
		return spots;
	}

	public void setSpots(ParkingSpot[] spots) {
		this.spots = spots;
	}

	public int getAvailableSpots() {
		return availableSpots;
	}

	public void setAvailableSpots(int availableSpots) {
		this.availableSpots = availableSpots;
	}

	public Level(int flr, int numberSpots) {
		floor = flr;
		ParkingSpotType size = Constants.DEFAULT_PARKINGSPOT_TYPE;
		spots = new ParkingSpot[numberSpots];
		for (int i = 0; i < numberSpots; i++) {
			spots[i] = new ParkingSpot(this, i, size);
		}

		availableSpots = numberSpots;
	}

	public boolean parkVehicle(Vehicle vehicle) {
		for (int i = 0; i < spots.length; i++) {
			if (spots[i].isFree()) {
				spots[i].setVehicle(vehicle);
				spots[i].setIsFree(false);
				availableSpots--;
				return true;
			}

		}
		return false;
	}

	public boolean unParkVehicle(int spotNumber) {
		for (int i = 0; i < spots.length; i++) {
			if (spots[i].getSpotNumber() == spotNumber) {
				spots[i].setVehicle(null);
				spots[i].setIsFree(true);
				availableSpots++;
				return true;
			}

		}
		return false;
	}

}
