package org.wecancodeit.columbus.plantplanner;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZipCodeLocality {

	@Id
	@GeneratedValue
	private Long id;

	@NaturalId
	private String zipcode;
	private String city;

	private String stateFull;
	private String stateAbbr;
	private String county;
	private String fipsCode;
	private double latitude;
	private double longitude;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private PrismZoneData zoneData;

	public String getCity() {
		return city;
	}

	public ZipCodeLocality(String zipcode, String city, String stateFull, String stateAbbr, String county,
			String fipsCode, double latitude, double longitude) {
		this.zipcode = zipcode;
		this.city = city;
		this.stateFull = stateFull;
		this.stateAbbr = stateAbbr;
		this.county = county;
		this.fipsCode = fipsCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public PrismZoneData getZoneData() {
		return zoneData;
	}

	public void setZoneData(PrismZoneData zoneData) {
		this.zoneData = zoneData;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateFull() {
		return stateFull;
	}

	public void setStateFull(String stateFull) {
		this.stateFull = stateFull;
	}

	public String getStateAbbr() {
		return stateAbbr;
	}

	public void setStateAbbr(String stateAbbr) {
		this.stateAbbr = stateAbbr;
	}

	public String getCounty() {
		return county;
	}

	public String getZone() {
		return zoneData.getZone();
	}
	
	public void setCounty(String county) {
		this.county = county;
	}

	public String getFipsCode() {
		return fipsCode;
	}

	public void setFipsCode(String fipsCode) {
		this.fipsCode = fipsCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public ZipCodeLocality() {
	}
	
	public ZipCodeLocality addZoneData(PrismZoneData zoneData) {
		this.zoneData = zoneData;
		zoneData.locality.add(this);
		return this;
	}

	@Override
	public String toString() {
		return "ZipCodeLocality [zipcode=" + zipcode + ", city=" + city + ", stateFull=" + stateFull + ", stateAbbr="
				+ stateAbbr + ", county=" + county + ", fipsCode=" + fipsCode + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", zoneData="+ zoneData+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ZipCodeLocality)) {
			return false;
		}
		ZipCodeLocality other = (ZipCodeLocality) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	

}
