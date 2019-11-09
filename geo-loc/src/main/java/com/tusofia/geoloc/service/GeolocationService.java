package com.tusofia.geoloc.service;

import com.tusofia.geoloc.model.Ambiguities;
import com.tusofia.geoloc.model.PortType;
import com.tusofia.geoloc.model.Route;

public interface GeolocationService {
	public Route getRoutes(String from, String to, PortType portType, Ambiguities ambiguities);
}
