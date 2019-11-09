package com.tusofia.geoloc.model;

public enum Ambiguities {
	CHECK("check"),
	IGNORE("ignore");
	
	private String ambiguities;
	
	private Ambiguities(String ambiguities) {
		this.ambiguities = ambiguities;
	}

	public String getAmbiguities() {
		return ambiguities;
	}
	
}
