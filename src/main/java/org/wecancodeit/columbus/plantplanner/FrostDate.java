package org.wecancodeit.columbus.plantplanner;

public class FrostDate {

	private ZipCodeLocality zipCode;

	public FrostDate(ZipCodeLocality testZipCode) {
		zipCode = testZipCode;

	}

	public ZipCodeLocality getZipCode() {
		return zipCode;
	}

	public String findClosestStation() {
		// double latitude = zipCode.getLatitude();
		// double longitude = zipCode.getLongitude();
		// RestTemplate findStationTemplate = new RestTemplate();
		// JsonNode targetStations = findStationTemplate.;
		return "502102";
	}

}
