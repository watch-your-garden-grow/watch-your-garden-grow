package org.wecancodeit.columbus.plantplanner;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Zone {

	@Id
	@GeneratedValue
	private long id;

	@ManyToMany(mappedBy = "zones")
	private Collection<Plant> plants;

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

	public Collection<Plant> getPlants() {
		return plants;
	}

	@Override
	public String toString() {
		return zone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Zone) obj).id;
	}
}
