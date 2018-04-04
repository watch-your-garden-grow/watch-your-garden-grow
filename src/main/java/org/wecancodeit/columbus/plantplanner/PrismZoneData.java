package org.wecancodeit.columbus.plantplanner;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrismZoneData {

	@Id
	@GeneratedValue
	private Long id;

	@Transient
	String zipcode;
	private String zone;

	private String trange;
	private String zonetitle;

	@OneToMany(mappedBy = "zoneData", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	Set<ZipCodeLocality> locality = new HashSet<>();

	public Set<ZipCodeLocality> getLocality() {
		return locality;
	}

	public void setLocality(Set<ZipCodeLocality> locality) {
		this.locality = locality;
	}

	public PrismZoneData() {
	}

	public PrismZoneData(String zipcode, String zone) {
		this.zipcode = zipcode;
		this.zone = zone;
	}

	public PrismZoneData(String zipcode, String zone, String trange, String zonetitle) {
		this.zipcode = zipcode;
		this.zone = zone;
		this.trange = trange;
		this.zonetitle = zonetitle;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getTrange() {
		return trange;
	}

	public void setTrange(String trange) {
		this.trange = trange;
	}

	public String getZonetitle() {
		return zonetitle;
	}

	public void setZonetitle(String zonetitle) {
		this.zonetitle = zonetitle;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "PrismZoneData [zone=" + zone + ", trange=" + trange + ", zonetitle=" + zonetitle + "]";
	}

	String getZipcode() {
		return zipcode;
	}

	void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
