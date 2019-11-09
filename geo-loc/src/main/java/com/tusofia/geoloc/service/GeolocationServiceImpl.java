package com.tusofia.geoloc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tusofia.geoloc.model.Ambiguities;
import com.tusofia.geoloc.model.PortType;
import com.tusofia.geoloc.model.Route;

@Service
@PropertySource("classpath:application.properties")
public class GeolocationServiceImpl implements GeolocationService {

	@Value("${geoloc.api.key}")
	private String apiKey;
	
	@Value("${geoloc.api.uri}")
	private String uri;

	@Override
	public Route getRoutes(String from, String to, PortType portType, Ambiguities ambiguities) {
		RestTemplate restTemplate = new RestTemplate();
		
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("key", apiKey);
	    params.put("from", from);
	    params.put("to", to);
	    params.put("portType", portType.getPortType());
	    params.put("ambiguities", ambiguities.getAmbiguities());
	     
	   Route route = restTemplate.getForObject(uri, Route.class, params);
	   
	   return route;


	}

}
