package org.wecancodeit.columbus.plantplanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Zone {

	@Id
	@GeneratedValue
	private long id;

	private String zone;

	public Zone() {

	}

	public Zone(String zone) {
		this.zone = zone;
	}

	public long getId() {
		return id;
	}

	public String getZoneName() {
		return zone;
	}

}
