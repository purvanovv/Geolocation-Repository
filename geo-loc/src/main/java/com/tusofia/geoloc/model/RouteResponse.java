package com.tusofia.geoloc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteResponse {
	
	private Route route;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	
	
}
