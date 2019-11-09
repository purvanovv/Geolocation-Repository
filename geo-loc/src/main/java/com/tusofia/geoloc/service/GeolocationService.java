package com.tusofia.geoloc.service;

import com.tusofia.generated.Ambiguities;
import com.tusofia.generated.PortType;
import com.tusofia.geoloc.model.RouteResponse;


public interface GeolocationService {
	public RouteResponse getRoute(String from, String to, PortType portType, Ambiguities ambiguities);
}
