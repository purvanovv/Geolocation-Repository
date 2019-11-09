package com.tusofia.geoloc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.tusofia.generated.GetRouteRequest;
import com.tusofia.generated.GetRouteResponse;
import com.tusofia.geoloc.model.RouteResponse;
import com.tusofia.geoloc.service.GeolocationService;

@Endpoint
public class GeolocationsEndpoint {

	private static final String NAMESPACE_URI = "https://www.geolocation.com/route/directions";

	private GeolocationService geolocationService;

	@Autowired
	public GeolocationsEndpoint(GeolocationService geolocationService) {
		this.geolocationService = geolocationService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetRouteRequest")
	@ResponsePayload
	public GetRouteResponse getDirections(@RequestPayload GetRouteRequest request) {
		GetRouteResponse response = new GetRouteResponse();
		RouteResponse routeResponse = this.geolocationService.getRoute(request.getFrom(), request.getTo(),
				request.getPortType(), request.getAmbiguities());

		response.setDistance(routeResponse.getRoute().getDistance());
		return response;
	}
}
