package org.wecancodeit.columbus.plantplanner;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

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
	private Collection<Zone> zones;

	public Collection<Zone> getZones() {
		return zones;
	}

	public Plant() {

	}

	public Plant(String name, Zone... zones) {
		this.name = name;
		this.zones = new HashSet<>(asList(zones));

	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
