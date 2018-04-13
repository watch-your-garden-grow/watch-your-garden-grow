package org.wecancodeit.columbus.plantplanner.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Zone {

	@Id
	@GeneratedValue
	private Long id;

	private String zone;

	@ManyToMany(mappedBy = "zones")
	private Collection<Plant> plants;

	public Long getId() {
		return id;
	}

	public String getZoneName() {
		return zone;
	}

	public Collection<Plant> getPlants() {
		return plants;
	}

	public Zone() {
	}

	public Zone(String zone) {
		this.zone = zone;
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
