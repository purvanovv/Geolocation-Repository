package com.tusofia.geoloc.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.tusofia.generated.Ambiguities;
import com.tusofia.generated.PortType;
import com.tusofia.geoloc.model.RouteResponse;

@Service
@PropertySource("classpath:application.properties")
public class GeolocationServiceImpl implements GeolocationService {

	@Value("${geoloc.api.key}")
	private String apiKey;

	@Value("${geoloc.api.uri}")
	private String uri;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public RouteResponse getRoute(String from, String to, PortType portType, Ambiguities ambiguities) {
				
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", apiKey);
		params.put("from", from);
		params.put("to", to);
		params.put("routeType", portType.value());
		params.put("ambiguities", ambiguities.value());
		params.put("outFormat", "json");
		params.put("doReverseGeocode",false);
		params.put("enhancedNarrative", false);
		params.put("avoidTimedConditions" , false);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		RouteResponse direction = null;

		try {
			direction = restTemplate.getForObject(uri, RouteResponse.class, params);
		} catch (RestClientException e) {
			e.printStackTrace();
		}

		return direction;

	}

}
