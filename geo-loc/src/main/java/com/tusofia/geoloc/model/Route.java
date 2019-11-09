package com.tusofia.geoloc.model;

public class Route {
	private boolean hasTollRoad;
	private boolean hasBridge;
	private Double distance;
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
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	
}
