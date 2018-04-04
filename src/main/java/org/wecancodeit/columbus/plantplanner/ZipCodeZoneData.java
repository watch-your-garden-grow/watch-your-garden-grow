package org.wecancodeit.columbus.plantplanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ZipCodeZoneData {

	private String city;

	@Id
	@GeneratedValue
	private Long id;

	private int latitude;
	private int longitude;
	private String state;
	private String tempuratures;
	private String zipcode;
	private String zone;

	public String getCity() {
		return city;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public String getState() {
		return state;
	}

	public String getTempuratures() {
		return tempuratures;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getZone() {
		return zone;
	}

	public ZipCodeZoneData() {
	}

	public ZipCodeZoneData(String zipcode, String zone) {
		this.zipcode = zipcode;
		this.zone = zone;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setTempuratures(String tempuratures) {
		this.tempuratures = tempuratures;
	}

	@Override
	public String toString() {
		return "ZipCodeZoneData [zipcode=" + zipcode + ", zone=" + zone + ", latitude=" + latitude + ", longitude="
				+ longitude + ", city=" + city + ", state=" + state + ", tempuratures=" + tempuratures + "]";
	}

}
