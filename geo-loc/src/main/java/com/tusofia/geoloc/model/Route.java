package com.tusofia.geoloc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {
private boolean hasTollRoad;
	
	private boolean hasBridge;
	
	private String distance;
	
	private String fuelUsed;

	public boolean isHasTollRoad() {
		return hasTollRoad;
	}

	public void setHasTollRoad(boolean hasTollRoad) {
		this.hasTollRoad = hasTollRoad;
	}

	public boolean isHasBridge() {
		return hasBridge;
	}

	public void setHasBridge(boolean hasBridge) {
		this.hasBridge = hasBridge;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getFuelUsed() {
		return fuelUsed;
	}

	public void setFuelUsed(String fuelUsed) {
		this.fuelUsed = fuelUsed;
	}
}
