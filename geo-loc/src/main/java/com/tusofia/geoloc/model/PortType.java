package com.tusofia.geoloc.model;

public enum PortType {
	FASTETS("fastest"),
	SHORTEST("shortest"), 
	PEDESTIAN("pedestrian"), 
	MULTIMODAL("multimodal"), 
	BICYCLE("bicycle");

	private final String portType;

	private PortType(String portType) {
		this.portType = portType;
	}

	public String getPortType() {
		return portType;
	}	

}