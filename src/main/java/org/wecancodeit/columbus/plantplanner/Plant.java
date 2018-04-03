package org.wecancodeit.columbus.plantplanner;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Plant {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@ManyToMany
	private Set<Zone> zones;

	public Set<Zone> getZones() {
		return zones;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Plant() {
	}

	public Plant(String name, Zone... zones) {
		this.name = name;
		this.zones = new HashSet<>(asList(zones));
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Plant) obj).id;
	}
}
