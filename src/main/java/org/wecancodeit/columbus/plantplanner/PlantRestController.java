package org.wecancodeit.columbus.plantplanner;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class PlantRestController {

	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(PlantRestController.class);

	@Resource
	private PlantRepository plantRepo;

	@Resource
	private ZoneRepository zoneRepo;

	@Resource
	private ZipCodeLocalityRepository zipCodeRepo;

	@RequestMapping("/plants")
	public Iterable<Plant> findPlants() {
		return plantRepo.findAll();
	}

	@RequestMapping("/plants/{id}")
	public Plant findPlant(@PathVariable(name = "id") long id) {
		if (plantRepo.findOne(id) == null) {
			throw new SomethingNotFoundException("Plant Not Found");
		}
		return plantRepo.findOne(id);
	}

	@RequestMapping("/zones")
	public Iterable<Zone> findZones() {
		return zoneRepo.findAll();
	}

	@RequestMapping("/zones/{id}")
	public Zone findZone(@PathVariable(name = "id") long id) {
		if (zoneRepo.findOne(id) == null) {
			throw new SomethingNotFoundException("Phz Not Found");
		}

		return zoneRepo.findOne(id);
	}

	@RequestMapping("/zone/{id}")
	public Iterable<Plant> findPlantsByZoneId(@PathVariable(name = "id") Long id) {
		return zoneRepo.findOne(id).getPlants();
	}

	public Iterable<Plant> findPlantsByZone(String zone) {
		return zoneRepo.findOneByZone(zone).getPlants();
	}

	@RequestMapping("/zipcode/{zipcode}")
	public String findPhzByZipcode(@PathVariable(name = "zipcode") String zipcode) {
		return zipCodeRepo.findZoneByZipCode(zipcode);
	}

	@RequestMapping("/frost/{zipcode}")
	public String findFrostDateByZipcode(@PathVariable(name = "zipcode") String zipcode) {

		ZipCodeLocality localityRow = zipCodeRepo.findOneByZipcode(zipcode);
		String latitude = Double.toString(localityRow.getLatitude());
		String longitude = Double.toString(localityRow.getLongitude());

		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);

		String farmsenseUrl = "http://farmsense-prod.apigee.net/v1/frostdates/";

		URI uri;
		uri = UriComponentsBuilder.fromHttpUrl(farmsenseUrl + "stations").queryParam("lat", latitude)
				.queryParam("lon", longitude).build().encode().toUri();

		JsonNode jsonResponse;
		jsonResponse = restTemplate.getForObject(uri, JsonNode.class);
		String stationId = jsonResponse.get(0).get("id").asText();

		uri = UriComponentsBuilder.fromHttpUrl(farmsenseUrl + "probabilities").queryParam("station", stationId)
				.queryParam("season", 1).build().encode().toUri();

		jsonResponse = restTemplate.getForObject(uri, JsonNode.class);
		String prob_30 = jsonResponse.get(1).get("prob_30").asText();

		return prob_30;

	}

	@RequestMapping("/plants/zipcode/{zipcode}")
	public Iterable<Plant> findPlantsByZipcode(@PathVariable(name = "zipcode") String zipcode) {
		String zoneName = zipCodeRepo.findZoneByZipCode(zipcode);
		if (zoneName == null) {
			throw new SomethingNotFoundException("Zipcode Not Found");
		}
		Zone targetZone = zoneRepo.findOneByZone(zoneName);
		if (targetZone == null) {
			throw new SomethingNotFoundException("Zone Not Found");
		}
		return targetZone.getPlants();
	}

	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class SomethingNotFoundException extends RuntimeException {
		private String message;

		public String getMessage() {
			return message;
		}

		SomethingNotFoundException(String errorMessage) {
			this.message = errorMessage;
		}
	}

	// @ExceptionHandler(SomethingNotFoundException.class)
	// @ResponseStatus(HttpStatus.NOT_FOUND)
	// public String handleSomethingNotFoundException(SomethingNotFoundException
	// errorException) {
	// return errorException.getErrorMessage();
	// }
}
