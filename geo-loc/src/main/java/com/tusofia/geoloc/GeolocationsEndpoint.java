package com.tusofia.geoloc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.tusofia.geoloc.service.GeolocationService;

@Endpoint
public class GeolocationsEndpoint {
	
	private static final String NAMESPACE_URI = "https://www.geolocation.com/route/directions";
 
	private GeolocationService geolocationService;
	
    @Autowired
    public GeolocationsEndpoint(GeolocationService geolocationService) {
        this.geolocationService = geolocationService;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDirectionsRequest")
    @ResponsePayload
    public GetDirectionsResponse getDirections(@RequestPayload GetDirectionsRequest request) {
    	GetDirectionsResponse response = new GetDirectionsResponse();
        response.setStudent(this.geolocationService.getRoutes(from, to, portType, ambiguities));
 
        return response;
    }
}
